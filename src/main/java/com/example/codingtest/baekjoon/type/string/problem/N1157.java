package com.example.codingtest.baekjoon.type.string.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1157 {
    public static void main(String[] args) throws IOException {
        N1157 n1157 = new N1157();
        n1157.init();
        n1157.countAlphabet();
    }

    private String inputWord;

    public void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputWord = bufferedReader.readLine();
    }

    public void countAlphabet() {
        Map<Integer, Integer> alphabetCountMap = new HashMap<>();

        for (char c : inputWord.toCharArray()) {
            int key;
            if (c >= 'a') {
                key = (int)c - 32;
            } else {
                key = (int)c;
            }
            alphabetCountMap.put(key, alphabetCountMap.getOrDefault(key, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(alphabetCountMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue() - e1.getValue());

        Map.Entry<Integer, Integer> entry1 = entryList.get(0);
        if (entryList.size() > 1) {
            Map.Entry<Integer, Integer> entry2 = entryList.get(1);

            if (entry1.getValue().equals(entry2.getValue())) {
                System.out.println("?");
            } else {
                System.out.println((char) (int) entry1.getKey());
            }
        } else {
            System.out.println((char) (int) entry1.getKey());
        }
    }
}
