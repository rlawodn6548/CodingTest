package com.example.codingtest.datastructure.problem1;

import java.util.PriorityQueue;

public class Problem_1 {
    private PriorityQueue<Integer> pq;

    public int solution(int[] nums){
        int answer = 0;

        init();

        for (int num : nums) {
            pq.add(num);
        }
        int max = 0;
        int count = 0;
        int prv = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            if (poll == prv + 1) {
                count++;
            } else if (poll == prv) {
                continue;
            } else {
                if (max < count) {
                    max = count;
                }
                count = 1;
            }
            prv = poll;
        }

        if (max < count) {
            max = count;
        }
        answer = max;
        return answer;
    }

    private void init() {
        pq = new PriorityQueue<>();
    }

    public static void main(String[] args){
        Problem_1 T = new Problem_1();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
