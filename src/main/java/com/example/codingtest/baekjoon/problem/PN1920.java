package com.example.codingtest.baekjoon.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PN1920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int aSize = scanner.nextInt();
        Map<Integer, Boolean> aMap = new HashMap<>();
        for (int i=0; i<aSize; i++) {
            aMap.put(scanner.nextInt(), true);
        }

        int mSize = scanner.nextInt();
        for (int i=0;i<mSize; i++) {
            int elem = scanner.nextInt();

            if (aMap.containsKey(elem)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
        String temp = "123";
    }
}

