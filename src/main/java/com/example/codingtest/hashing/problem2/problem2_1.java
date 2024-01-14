package com.example.codingtest.hashing.problem2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class problem2_1 {
    private Map<Character, Integer> count;
    private int max;

    public int[] solution(String s){
        int[] answer = new int[5];

        init();

        for (Character c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
            if (count.get(c) > max) {
                max = count.get(c);
            }
        }

        for (int i=0; i < 5; i++) {
            answer[i] = max - count.getOrDefault((char)(97+i), 0);
        }

        return answer;
    }

    private void init() {
        count = new HashMap<>();
        max = 0;
    }

    public static void main(String[] args){
        problem2_1 T = new problem2_1();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
