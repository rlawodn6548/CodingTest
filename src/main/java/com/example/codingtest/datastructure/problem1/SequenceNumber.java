package com.example.codingtest.datastructure.problem1;

import java.util.Arrays;

public class SequenceNumber {
    public static void main(String[] args){
        SequenceNumber T = new SequenceNumber();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }

    private int max;
    public int solution(int[] nums){
        int answer = 0;

        init();
        Arrays.sort(nums);
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] + 1 == nums[i]) {
                count++;
            } else if (nums[i-1] == nums[i]) {
                continue;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        answer = Math.max(max, count);
        return answer;
    }

    private void init() {
        max = 0;
    }


}
