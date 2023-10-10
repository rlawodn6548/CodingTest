package com.example.codingtest.hashing.problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlyOneCharacter {
    public static void main(String[] args){
        OnlyOneCharacter T = new OnlyOneCharacter();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }

    private Map<Character, Integer> counter;

    public int solution(String s){
        int answer = 0;
        init();

        for (char character : s.toCharArray()) {
            counter.put(character, counter.getOrDefault(character, 0) + 1);
        }

        for (int i=0; i<s.length(); i++){
            char targetCharacter = s.charAt(i);
            if (counter.get(targetCharacter) == 1) {
                return i+1;
            }
        }

        return -1;
    }

    private void init() {
        counter = new HashMap<>();
    }
}
