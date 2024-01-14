package com.example.codingtest.hashing.problem1;

import java.util.HashMap;
import java.util.Map;

public class Problem1_1 {

    private Map<Character, Integer> charMap;
    public int solution(String s){
        int answer = 0;

        init();

        for (Character c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c,0) + 1);
        }
        for (int i = 0; i < s.length(); i ++) {
            if (charMap.get(s.charAt(i)) == 1 ) {
                answer = i + 1;
                break;
            }
        }
        return answer == 0 ? -1 : answer;
    }

    private void init() {
        charMap = new HashMap<>();
    }

    public static void main(String[] args){
        Problem1_1 T = new Problem1_1();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
