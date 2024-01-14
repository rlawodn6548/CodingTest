package com.example.codingtest.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Problem3_1 {
    private PriorityQueue<Integer> inQ;
    private PriorityQueue<Integer> outQ;
    private int prev;
    private int time;

    public int[] solution(int[] arrival, int[] state){
        init();
        int[] answer = new int[arrival.length];
        int index = 0;

        while (true) {
            while (index < arrival.length && arrival[index] <= time) {
                if (state[index] == 0) {
                    inQ.add(index);
                } else {
                    outQ.add(index);
                }
                index++;
            }
            if (prev == 1) {
                if (outQ.isEmpty()) {
                    if (inQ.isEmpty()) {
                        if (index < arrival.length) {
                            time = arrival[index];
                            continue;
                        } else {
                            break;
                        }
                    }
                    prev = 0;
                } else {
                    Integer poll = outQ.poll();
                    answer[poll] = time;
                    time++;
                }
            } else {
                if (inQ.isEmpty()) {
                    if (outQ.isEmpty()) {
                        if (index < arrival.length) {
                            prev = 1;
                            time = arrival[index];
                            continue;
                        } else {
                            break;
                        }
                    }
                    prev = 1;

                } else {
                    Integer poll = inQ.poll();
                    answer[poll] = time;
                    time++;
                }
            }
        }

        return answer;
    }

    private void init() {
        inQ = new PriorityQueue<>();
        outQ = new PriorityQueue<>();
        prev = 1;
        time = 0;
    }

    public static void main(String[] args){
        Problem3_1 T = new Problem3_1();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
