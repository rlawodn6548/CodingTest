package com.example.codingtest.baekjoon.type.sort.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11004 {
    public static void main(String[] args) {
        N11004 n11004 = new N11004();
        n11004.initializeDataAndPrintNthData();
    }

    private int[] dataArray;
    private int nth;

    public void initializeDataAndPrintNthData() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int numData = Integer.parseInt(st.nextToken());
            dataArray = new int[numData];
            nth = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            for (int i=0; i<numData; i++) {
                dataArray[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(dataArray);
            System.out.println(dataArray[nth-1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
