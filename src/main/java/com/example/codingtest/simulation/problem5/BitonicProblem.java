package com.example.codingtest.simulation.problem5;

import java.util.ArrayList;
import java.util.List;

public class BitonicProblem {

    public static void main(String[] args){
        BitonicProblem T = new BitonicProblem();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }

    public int solution(int[] nums){
        int answer = 0;
        List<Integer> peekIndexs = new ArrayList<>();

        for (int i=1; i<nums.length-1; i++) {
            if (nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                peekIndexs.add(i);
            }
        }

        for (int index : peekIndexs) {
            int left = index;
            int right = index;
            int count = 1;

            while(left > 0 && nums[left-1] < nums[left]) {
                left--;
                count++;
            }
            while (right < nums.length -1 && nums[right+1] < nums[right]) {
                right++;
                count++;
            }

            answer = Math.max(count, answer);
        }

        return answer;
    }
}
