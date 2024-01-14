package com.example.codingtest.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    private Queue<int[]> queue;
    private int[] minDepth;

    public int solution(int[] nums){
        int answer = 0;
        init(nums);
        queue.add(new int[]{0,0});
        bfs(nums);
        answer = minDepth[nums.length-1] == Integer.MAX_VALUE ? -1 : minDepth[nums.length -1] ;
        return answer;
    }

    private void bfs(int[] nums) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int depth = poll[0];
            int index = poll[1];

            if (index < nums.length && minDepth[index] > depth) {
                minDepth[index] = depth;
            } else {
                continue;
            }

            for (int i = 1; i <= nums[index]; i++) {
                queue.add(new int[]{depth +1, index + i});
            }
        }
    }

    private void init(int[] nums) {
        queue = new LinkedList<>();
        minDepth = new int[nums.length];
        Arrays.fill(minDepth, Integer.MAX_VALUE);
    }

    public static void main(String[] args){
        Problem1 T = new Problem1();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
