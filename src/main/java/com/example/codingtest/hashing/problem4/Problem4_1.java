package com.example.codingtest.hashing.problem4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem4_1 {

    private Map<Integer, List<Integer>> candidate;

    public int solution(int[] nums, int m){
        int answer = 0;

        candidate = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        candidate.put(0, list);

        for (int i = 1 ; i < nums.length; i++) {
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(nums[i]);
            candidate.put(i, newList);

            List<Integer> prevIntegers = candidate.get(i - 1);
            for (Integer prev : prevIntegers) {
                newList.add(prev + nums[i]);
            }
        }

        for (Integer key : candidate.keySet()) {
            List<Integer> integers = candidate.get(key);
            for (Integer elem : integers) {
                if (elem == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Problem4_1 T = new Problem4_1();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
