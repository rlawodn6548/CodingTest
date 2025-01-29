package com.example.codingtest.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem6_1 {
    private PriorityQueue<int[]> taskQ;
    private PriorityQueue<Room> roomQ;
    private int[] cnt;

    public int solution(int n, int[][] meetings){
        int answer = 0;
        int curTime = 0;
        init(n, meetings);

        while (!taskQ.isEmpty()) {
            if (roomQ.peek().endTime <= curTime) {
                if (taskQ.peek()[0] <= curTime) {
                    int[] task = taskQ.poll();
                    Room room = roomQ.poll();
                    cnt[room.num]++;
                    room.endTime = curTime + task[1];
                    roomQ.add(room);
                } else {
                    curTime = taskQ.peek()[0];
                }
            } else {
                curTime = roomQ.peek().endTime;
            }
        }

        int max = 0;
        for (int i = 0; i<cnt.length; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                answer = i;
            }
        }

        return answer;
    }

    private void init(int n, int[][] meetings) {
        cnt = new int[n];
        taskQ = new PriorityQueue<>((a,b) -> a[0] <= b[0] ? -1 : 1);
        roomQ = new PriorityQueue<>((a, b) -> {
            if (a.endTime < b.endTime) {
                return -1;
            } else if (a.endTime == b.endTime) {
                if (a.num < b.num) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });

        for (int i=0; i<meetings.length; i++) {
            int[] elem = new int[2];
            elem[0] = meetings[i][0];
            elem[1] = meetings[i][1] - meetings[i][0];
            taskQ.add(elem);
        }

        for (int i=0; i<n; i++) {
            Room room = new Room();
            room.num=i;
            room.endTime=0;
            roomQ.add(room);
        }
    }

    class Room {
        int num;
        int endTime;
    }

    public static void main(String[] args){
        Problem6_1 T = new Problem6_1();
        System.out.println(T.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
        System.out.println(T.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    }
}
