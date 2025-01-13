package com.example.codingtest.baekjoon.type.search.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2343 {
    public static void main(String[] args) {
        N2343 n2343 = new N2343();
        n2343.init();
        n2343.calculateBlurayMinTime();
    }

    private int numbersSong;
    private int maxBluray;
    private int[] timeOfSongs;
    private int min;
    private int max;

    public void init() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            numbersSong = Integer.parseInt(st.nextToken());
            maxBluray = Integer.parseInt(st.nextToken());
            timeOfSongs = new int[numbersSong];

            st = new StringTokenizer(bf.readLine());
            min = Integer.MIN_VALUE;
            max = 0;
            for (int i = 0; i < numbersSong; i++) {
                timeOfSongs[i] = Integer.parseInt(st.nextToken());
                if (timeOfSongs[i] > min) {
                    min = timeOfSongs[i];
                }
                max += timeOfSongs[i];

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculateBlurayMinTime() {
        int minTime = Integer.MAX_VALUE;

        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 1;
            int sum = 0;
            int maxSum = 0;

            for (int time : timeOfSongs) {
                if (sum + time > mid) {
                    count++;
                    if (count > maxBluray) {
                        break;
                    }
                    maxSum = Math.max(maxSum, sum);
                    sum = time;
                    continue;
                }
                sum += time;
                maxSum = Math.max(maxSum, sum);
            }

            if (count > maxBluray) {
                min = mid +1;
            } else {
                max = maxSum-1;
                minTime = Math.min(minTime, maxSum);
            }
        }
        System.out.println(minTime);
    }
}
