package com.example.codingtest.baekjoon.type.greedy.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N11047 {
    public static void main(String[] args) {
        N11047 n11047 = new N11047();
        n11047.initCoin();
        n11047.findMinCoins();
    }

    private List<Integer> coinUnit;
    private int targetAmount;

    public void initCoin() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            coinUnit = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int numUnit = Integer.parseInt(st.nextToken());
            targetAmount = Integer.parseInt(st.nextToken());

            for (int i=0;i<numUnit;i++) {
                coinUnit.add(Integer.parseInt(bf.readLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void findMinCoins() {
        int totalCoins = 0;
        int remainingAmount = targetAmount;

        for (int i=coinUnit.size()-1; i>=0; i--) {
            int unit = coinUnit.get(i);

            if (unit > remainingAmount) {
                continue;
            }
            totalCoins += remainingAmount/unit;
            remainingAmount = remainingAmount%unit;

            if (remainingAmount == 0) {
                break;
            }
        }
        System.out.println(totalCoins);
    }
}
