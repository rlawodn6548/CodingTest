package com.example.codingtest.greedy;

import java.util.ArrayList;

public class Problem3 {
    public int solution(int n, int[] nums){
        int answer = 0;

        ArrayList<Integer[]> list = new ArrayList<>();
        for (int i = 0; i< nums.length ; i++) {
            if (nums[i] != 0) {
                list.add(new Integer[]{i - nums[i], i + nums[i]});
            }
        }

        list.sort((a,b) -> a[0]-b[0]);

        int index = 0;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer[] scope = list.get(i);
            if (scope[0] <= index) {
                max = Math.max(max, scope[1]);
                if (max >= n) {
                    answer++;
                    break;
                }
            } else {
                if (max < index) {
                    return -1;
                }
                index = max;
                answer++;
            }
        }
        if (max < n) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args){
        Problem3 T = new Problem3();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}
