package com.example.codingtest.simulation.problem8;

import java.util.ArrayList;
import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args){
        MeetingRoom T = new MeetingRoom();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }

    private int[] records;
    private ArrayList<Integer> room;

    public int[] solution(int[] enter, int[] exit){
        int[] answer = {};

        init(enter);
        int inputIndex = 0;

        for (int i = 0; i<exit.length; i++) {
            if (room.contains(exit[i])) {
                room.remove(room.indexOf(exit[i]));
                continue;
            }
            while (inputIndex < enter.length) {
                for (int inner : room) {
                    records[inner-1]++;
                }
                records[enter[inputIndex]-1] = room.size();
                room.add(enter[inputIndex]);
                inputIndex++;
                if (enter[inputIndex-1] == exit[i]) {
                    room.remove(room.indexOf(exit[i]));
                    break;
                }
            }
        }

        answer = records;
        return answer;
    }

    private void init(int[] enter) {
        records = new int[enter.length];
        room = new ArrayList<>();
    }


}
