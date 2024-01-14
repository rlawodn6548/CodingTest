package com.example.codingtest.dfs;

import java.util.Arrays;

public class Problem1_1 {
    private char[] elem;
    private boolean[] used;
    private int origin;
    private int size;
    private int candidate;


    public int solution(int n){
        int answer = 0;
        init(n);

        char[] temp = new char[elem.length];

        dfs(temp, 0);

        answer = candidate == Integer.MAX_VALUE ? -1: candidate;
        return answer;
    }

    private void dfs(char[] cur, int depth) {
        if (depth == size) {
            StringBuilder curValue = new StringBuilder();
            for (char c : cur) {
                curValue.append(c);
            }
            int value = Integer.parseInt(curValue.toString());
            if (value > origin && candidate > value) {
                candidate = value;
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            if (used[i]) {
                continue;
            }
            cur[depth] = elem[i];
            used[i] = true;
            dfs(cur, depth+1);
            used[i] = false;
        }

    }

    private void init(int n) {
        String numbers = ""+n;
        size = numbers.length();
        elem = new char[size];
        used = new boolean[size];
        origin = n;
        candidate = Integer.MAX_VALUE;

        for (int i = 0; i<size; i++) {
            elem[i] = numbers.charAt(i);
        }
        Arrays.fill(used, false);
    }

    public static void main(String[] args){
        Problem1_1 T = new Problem1_1();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
