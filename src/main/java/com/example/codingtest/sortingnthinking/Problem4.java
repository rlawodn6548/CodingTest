package com.example.codingtest.sortingnthinking;

import java.util.Arrays;

public class Problem4 {
    public static void main(String[] args){
        Problem4 T = new Problem4();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }


    public int solution(int[] score, int k){
        int answer = 0;

        init(score);

        for (int i=0; i < score.length - k; i++) {
            if (score[i+k-1] - score[i] <= 10) {
                for (int j = i; j < i + k; j++) {
                    answer += score[j];
                }
                break;
            }
        }

        return answer/k;
    }

    private void init(int[] score) {
        Arrays.sort(score);
    }


}
