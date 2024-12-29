package com.example.codingtest.baekjoon.type.dynamic.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N1003 {
    private List<Integer> fList;
    private int pNum;
    private List<Integer> pList;

    public static void main(String[] args) {
        N1003 n1003 = new N1003();
        n1003.init();
        n1003.printFivot();
    }

    private void init() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        
            fList = new ArrayList<>();
            pList = new ArrayList<>();
            pNum = Integer.parseInt(bufferedReader.readLine());
            
            for (int i=0; i<pNum; i++) {
                pList.add(Integer.parseInt(bufferedReader.readLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void printFivot() {
        for (Integer p : pList) {
            System.out.println(getUseNumberOfFZero(p) + " " + getUseNumberofFOne(p));
        }
    }

    private int getUseNumberOfFZero(int n) {
        if (n == 0) {
            return 1;
        }
        if (n==1) {
            return 0;
        }
        return f(n-2);
    }

    private int getUseNumberofFOne(int n) {
        if (n==0) {
            return 0;
        }
        return f(n-1);
    }

    private int f(int n) {
        if (n >= fList.size()) {
            for (int i = fList.size(); i <= n; i++) {
                if (i == 0 || i == 1) {
                    fList.add(1);
                } else {
                    fList.add(fList.get(i - 1) + fList.get(i - 2));
                }
            }
        }
        return fList.get(n);
    }
}
