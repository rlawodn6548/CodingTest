package com.example.codingtest.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class problem3 {
    public static void main(String[] args){
        problem3 T = new problem3();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }

    private Queue<Integer> out = new LinkedList<>();
    private Queue<Integer> in = new LinkedList<>();
    private int[] answer;
    public int[] solution(int[] arrival, int[] state){
        answer = new int[arrival.length];
        int time = 0;
        int prev = 1;
        int index = 0;

        while(true) {
            while (index < arrival.length && time == arrival[index]) {
                int employeeState = state[index];

                if (employeeState == 0) {
                    in.add(index);
                } else {
                    out.add(index);
                }
                index++;
            }

            if (prev == 1) {
                if (!out.isEmpty()) {
                    Integer employee = out.poll();
                    answer[employee] = time;
                } else {
                    if (!in.isEmpty()) {
                        Integer employee = in.poll();
                        answer[employee] = time;
                        prev = 0;
                    } else {
                        prev = 1;
                    }
                }
            } else {
                if (!in.isEmpty()) {
                    Integer employee = in.poll();
                    answer[employee] = time;
                } else {
                    if (!out.isEmpty()) {
                        Integer employee = out.poll();
                        answer[employee] = time;
                        prev = 0;
                    } else {
                        prev = 1;
                    }
                }
            }
            time++;

            if (index >= arrival.length && in.isEmpty() && out.isEmpty()) {
                break;
            }
        }


        return answer;
    }

}
