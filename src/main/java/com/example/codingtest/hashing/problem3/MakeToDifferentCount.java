package com.example.codingtest.hashing.problem3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MakeToDifferentCount {
    public static void main(String[] args){
        MakeToDifferentCount T = new MakeToDifferentCount();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }

    private Map<Character, Integer> counter;

    public int solution(String s){
        int answer = 0;
        init(s);

        Object[] valueArray = counter.values().toArray();
        for (int i=0; i<valueArray.length; i++) {
            for (int j=0; j<valueArray.length; j++) {
                if (i == j) {
                    continue;
                }
                if ((int)valueArray[i] == 0) {
                    break;
                }
                if (valueArray[i] == valueArray[j]) {
                    valueArray[i] = (int)valueArray[i] - 1;
                    answer++;
                    i--;
                    break;
                }
            }
        }

        return answer;
    }

    private void init(String s) {
        counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) +1);
        }
    }


}
