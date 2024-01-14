package com.example.codingtest.hashing.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem3_1 {

    private Map<Character, Integer> count;
    private int cnt;
    public int solution(String s){
        int answer = 0;

        init();

        for (Character c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        Object[] array = count.values().toArray();

        for (int i = 0 ; i <array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i ==j) {
                    continue;
                }
                if ((int)array[i] == 0) {
                    break;
                }
                if (array[i] == array[j]) {
                    array[i] = (int)array[i] -1;
                    cnt++;
                    i--;
                    break;
                }
            }
        }


        return cnt;
    }

    private void init() {
        count = new HashMap<>();
        cnt = 0;
    }

    public static void main(String[] args){
        Problem3_1 T = new Problem3_1();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
