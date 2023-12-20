package com.example.codingtest.datastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem6 {

    public static void main(String[] args){
        Problem6 T = new Problem6();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }

    private PriorityQueue<Meeting> taskQ;
    private PriorityQueue<Room> roomQ;
    private int[] rooms;
    private int curT;

    public int solution(int n, int[][] meetings){
        int answer=0;

        init(n, meetings);

        while (!taskQ.isEmpty()) {
            Meeting poll = taskQ.poll();
            if (curT < poll.getStart()) {
                curT = poll.getStart();
            }
            Room room = roomQ.poll();
            if (room.getEndTime() > curT) {
                curT = room.getEndTime();
            }
            room.setEndTime(curT + poll.duration);
            room.use();
            roomQ.add(room);
        }

        int use = 0;
        while (!roomQ.isEmpty()) {
            Room room = roomQ.poll();
            if (use <= room.getCount()) {
                if (use == room.getCount()) {
                    if (answer > room.getNumber()) {
                        answer = room.getNumber();
                    }
                } else {
                    use = room.getCount();
                    answer = room.getNumber();
                }
            }
        }
        return answer;
    }

    private void init(int roomNumber, int[][] meetings) {
        taskQ = new PriorityQueue<>((a, b) -> {
            if (a.getStart() <= b.getStart()) {
                return -1;
            } else {
                return 1;
            }
        });
        roomQ = new PriorityQueue<>((a, b) -> {
            if (a.getEndTime() < b.getEndTime()) {
                return -1;
            } else if (a.getEndTime() == b.getEndTime()) {
                if (a.getNumber() < b.getNumber()) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });
        curT = 0;

        for (int i=0 ; i<meetings.length; i++) {
            int[] meetingArray = meetings[i];
            Meeting meeting = new Meeting(meetingArray[0], meetingArray[1] - meetingArray[0]);
            taskQ.add(meeting);
        }
        for (int i=0; i<roomNumber; i++) {
            Room room = new Room(i, 0, 0);
            roomQ.add(room);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Meeting {
        private int start;
        private int duration;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Room {
        private int number;
        private int endTime;
        private int count;

        public void use() {
            count++;
        }
    }
}
