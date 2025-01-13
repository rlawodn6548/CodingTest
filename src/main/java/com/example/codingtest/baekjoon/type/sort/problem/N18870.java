package com.example.codingtest.baekjoon.type.sort.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N18870 {
    public static void main(String[] args) {
        N18870 n18870 = new N18870();
        n18870.initailizeData();
        n18870.sortNumbersAndPrint();
    }

    private int nums;
    private int[] numbers;
    private int[] sortedNumbers;

    public void initailizeData() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            nums = Integer.parseInt(bf.readLine());
            numbers = new int[nums];
            sortedNumbers = new int[nums];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i=0 ;i<nums; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
                sortedNumbers[i] = numbers[i];
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sortNumbersAndPrint() {
        int rank = 0;
        Map<Integer, Integer> rankMap = new HashMap<>();

        Arrays.sort(sortedNumbers);
        for (int value : sortedNumbers) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int elem : numbers) {
            sb.append(rankMap.get(elem)).append(" ");
        }
        System.out.println(sb);
    }
}
