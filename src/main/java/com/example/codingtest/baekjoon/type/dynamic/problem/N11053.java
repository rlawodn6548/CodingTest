package com.example.codingtest.baekjoon.type.dynamic.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11053 {
    public static void main(String[] args) {
        N11053 n11053 = new N11053();
        n11053.init();
        n11053.calculateNumberOfOrder();
    }
    private int listSize;
    private int[] list;
    private int[] dp;

    private void init() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            listSize = Integer.parseInt(bf.readLine());
            list = new int[listSize];
            dp = new int[listSize];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i=0; i<listSize; i++) {
                list[i] = Integer.parseInt(st.nextToken());
                dp[i]=1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void calculateNumberOfOrder() {
        int max = 0;

        for (int i=0; i<listSize; i++) {
            for (int j=0;j<i;j++) {
                if (list[j] < list[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
