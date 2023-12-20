package com.example.codingtest.sortingnthinking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    public static void main(String[] args){
        Problem2 T = new Problem2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }

    private Map<Integer, Integer> cntMap;

    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length / 2];

        init();

        for (int num :nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(nums);

        int index = 0;
        for (int num : nums) {
            if (cntMap.get(num) == 0) {
                continue;
            }
            answer[index++] = num;
            cntMap.put(num, cntMap.get(num) -1);
            cntMap.put(num *2, cntMap.get(num*2)-1);
        }

        return answer;
    }

    private void init() {
        cntMap = new HashMap<>();
    }
}
