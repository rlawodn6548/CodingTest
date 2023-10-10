package com.example.codingtest.hashing.problem2;

import java.util.*;

public class MakeToSameCount {
    public static void main(String[] args){
        MakeToSameCount T = new MakeToSameCount();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }

    private Map<Character, Integer> counter;
    private char[] keyArray;

    public int[] solution(String s){
        int[] answer = new int[5];
        init();

        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) +1);
        }

        int max = 0;
        for (Character c : counter.keySet()) {
            if (max < counter.get(c)) {
                max = counter.get(c);
            }
        }

        for (int i=0; i<keyArray.length; i++) {
            Integer number = counter.get(keyArray[i]);
            answer[i] = max- number;
        }

        return answer;
    }

    private void init() {
        keyArray = new char[]{'a', 'b', 'c', 'd', 'e'};
        counter = new HashMap<>();
        for (char key : keyArray) {
            counter.put(key, 0);
        }

    }
}
