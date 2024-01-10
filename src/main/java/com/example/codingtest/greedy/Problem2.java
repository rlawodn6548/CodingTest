package com.example.codingtest.greedy;

import java.util.Arrays;

public class Problem2 {

    private int right;
    private int left;

    public int solution(int[] nums){
        int answer = 0;
        left = 0;
        right = nums.length-1;

        Arrays.sort(nums);

        while (left <= right) {
            collect(nums, 5);
            answer++;
        }

        return answer;
    }

    private void collect(int[] nums, int m) {
        if (nums[left] + nums[right] <= m) {
            left++;
            right--;
            if (left > right) {
                return;
            }
            collect(nums, m - nums[left] - nums[right]);
        } else {
            if (nums[right] <= m) {
                right--;
            } else if (nums[left] <= m){
                left++;
            }
        }
    }

    public static void main(String[] args){
        Problem2 T = new Problem2();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
