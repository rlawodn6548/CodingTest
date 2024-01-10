package com.example.codingtest.yanolza.codingtest;

public class Problem1 {
    public int solution(int[] boiler){
        int answer = boiler.length+1;
        int min = cal(boiler);
        int origin = min;

        for(int i = 0 ; i< boiler.length; i++) {
            exchange(i, boiler);

            int sum = cal(boiler);
            if (min > sum){
                min = sum;
                answer = i;
            } else if (min == sum) {
                if (answer > i) {
                    answer = i;
                }
            }
            exchange(i, boiler);
        }

        if (origin == min) {
            return -1;
        }
        return answer + 1;
    }

    private int cal(int[] boiler) {
        int total = 0;
        int cnt=0;
        for (int i = 0 ; i<boiler.length;i++) {
            if (boiler[i] == 1) {
                cnt++;
                total+=cnt;
            } else {
                cnt = 0;
            }
        }

        return total;
    }

    private void exchange(int start, int[] boiler) {
        for (int i = start; i<boiler.length;i++) {
            if (boiler[i] == 0) {
                boiler[i] =1;
            } else {
                boiler[i]=0;
            }
        }
    }

    public static void main(String[] args){
        Problem1 T = new Problem1();
        System.out.println(T.solution(new int[]{0}));
        System.out.println(T.solution(new int[]{1,1,0,0,1,1,1,0,0,1}));
        System.out.println(T.solution(new int[]{0,1,0}));
        System.out.println(T.solution(new int[]{0,1,1,0,1,1,0,0,0,1,0,1,1}));
      }
}
