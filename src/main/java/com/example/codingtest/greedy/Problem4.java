package com.example.codingtest.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem4 {
    public int solution(int[] plantTime, int[] growTime){
        int answer = 0;
        int time = 0;
        int[][] pair = new int[plantTime.length][2];

        for (int i = 0; i<plantTime.length; i++) {
            pair[i][0] = plantTime[i];
            pair[i][1] = growTime[i];
        }

        Arrays.sort(pair, (a,b)-> b[1] > a[1] ? 1 : -1);

        for (int i = 0; i < pair.length; i++) {
            time += pair[i][0];
            answer = Math.max(answer, time + pair[i][1]);
        }

        return answer;
    }

    public static void main(String[] args){
        Problem4 T = new Problem4();
        System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
        System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
        System.out.println(T.solution(new int[]{1, 1, 1,1}, new int[]{7,7, 3, 2}));
        System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
    }

}
