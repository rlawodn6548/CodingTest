package com.example.codingtest.baekjoon.type.dynamic.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N2579 {
    public static void main(String[] args) {
        N2579 n2579 = new N2579();
        n2579.init();
        n2579.calculate();
    }

    private List<Score> maxScore;
    private int[] score;


    public void init() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(bf.readLine());
            maxScore = new ArrayList<>();
            score = new int[num+1];

            for (int i=1; i<=num; i++) {
                score[i] = Integer.parseInt(bf.readLine());
                maxScore.add(new Score());
            }
            maxScore.add(new Score());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculate() {
        maxScore.get(1).score = score[1];
        maxScore.get(1).sequenceCnt = 1;

        for (int i=2; i< maxScore.size(); i++) {
            if (maxScore.get(i-1).sequenceCnt <2) {
                if (maxScore.get(i - 1).score > maxScore.get(i - 2).score) {
                    maxScore.get(i).score = score[i] + maxScore.get(i - 1).score;
                    maxScore.get(i).sequenceCnt = maxScore.get(i-1).sequenceCnt+1;
                } else {
                    maxScore.get(i).score = score[i] + maxScore.get(i - 2).score;
                    maxScore.get(i).sequenceCnt = 1;
                }
            } else {
                maxScore.get(i).score = score[i] + maxScore.get(i-2).score;
                maxScore.get(i).sequenceCnt = 1;
            }
        }

        System.out.println(maxScore.get(maxScore.size()-1).score);
    }

    class Score {
        int score;
        int sequenceCnt;
    }
}
