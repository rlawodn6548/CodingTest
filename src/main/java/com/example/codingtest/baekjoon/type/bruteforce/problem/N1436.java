package com.example.codingtest.baekjoon.type.bruteforce.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1436 {
    public static void main(String[] args) {
        N1436 n1436 = new N1436();
        n1436.init();
        n1436.countNth();
    }

    private int nth;

    public void init() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            nth = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void countNth() {
        int count = 0; // Count of apocalypse numbers found
        int number = 666; // Start checking from 666

        while (count < nth) {
            // Check if the current number contains "666" efficiently
            int temp = number;
            boolean contains666 = false;

            while (temp > 0) {
                if (temp % 1000 == 666) {
                    contains666 = true;
                    break;
                }
                temp /= 10;
            }

            if (contains666) {
                count++;
            }

            if (count == nth) {
                break;
            }

            number++;
        }
        System.out.println(count);
    }
}
