package com.example.codingtest.datastructure.problem1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SequenceNumber2 {
    public static void main(String[] args){
        SequenceNumber2 T = new SequenceNumber2();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }

    private Set<Integer> set;
    public int solution(int[] nums){
        int answer = 0;

        init(nums);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (set.contains(next -1)) {
                continue;
            }
            int x = 1;
            int count = 1;
            while (set.contains(next + x)) {
                x++;
                count++;
            }
            answer = Math.max(count, answer);
        }

        return answer;
    }

    private void init(int[] nums) {
       set = new HashSet<>();
       for (int i=0; i<nums.length; i++) {
           set.add(nums[i]);
       }
    }


}
