package com.example.codingtest.baekjoon.type.search.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2110 {
    public static void main(String[] args) {
        N2110 n2110 = new N2110();
        n2110.init();
        n2110.calculateWifi();
    }

    private int numsWifi;
    private Integer[] homes;
    private int minInterval;
    private int maxInterval;


    public void init() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int numsHome = Integer.parseInt(st.nextToken());
            numsWifi = Integer.parseInt(st.nextToken());
            homes = new Integer[numsHome];

            for (int i=0; i<numsHome; i++) {
                homes[i] = Integer.parseInt(bf.readLine());
            }

            Arrays.sort(homes);
            minInterval = Integer.MAX_VALUE;
            for (int i=0; i<numsHome-1; i++) {
                minInterval = Math.min(minInterval, homes[i+1] - homes[i]);
            }
            maxInterval = homes[numsHome-1] - homes[0];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculateWifi() {
        int maxNear = 0;

        while (minInterval <= maxInterval) {
            int mid = (minInterval + maxInterval)/2;
            int count = 1;
            int start = homes[0];

            for (int i=1; i<homes.length; i++) {
                if (homes[i] - start >= mid) {
                    count++;
                    start = homes[i];
                }
            }
            if (count < numsWifi) {
                maxInterval = mid -1;
            } else {
                minInterval = mid + 1;
                maxNear = Math.max(maxNear, mid);
            }
        }
        System.out.println(maxNear);
    }
}