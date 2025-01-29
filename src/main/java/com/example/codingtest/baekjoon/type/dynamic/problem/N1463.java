package com.example.codingtest.baekjoon.type.dynamic.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1463 {
    public static void main(String[] args) {
        N1463 n1463 = new N1463();
        n1463.init();
        n1463.getMinCalculate();
    }

    private int n;
    private int[] list;

    private void init() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(bf.readLine());
            list = new int[n+1];
            Arrays.fill(list, Integer.MAX_VALUE);
            list[n]=0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getMinCalculate() {
        for (int i=n; i>0; i--) {
            if (i%3==0) {
                list[i/3] = Math.min(list[i]+1, list[i/3]);
            }
            if (i%2==0) {
                list[i/2] = Math.min(list[i]+1, list[i/2]);
            }
            list[i-1] = Math.min(list[i]+1, list[i-1]);
        }
        System.out.println(list[1]);
    }
}
