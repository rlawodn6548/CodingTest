package com.example.codingtest.baekjoon.type.sort.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2750 {

    private int num;
    private List<Integer> list;


    public static void main(String[] args) {
        P2750 main = new P2750();
        main.init();
        main.callSort();
    }

    private void callSort() {
//        sort();
        quickSort(0, list.size()-1);

        for (int i=0; i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }

    private void sort() {
        list.sort((a, b) -> {
            return a < b?-1:1;
        });


    }

    private void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = list.get(end);
        int s = start;
        int e = end-1;
        int temp;

        while (s != e) {
            if (list.get(s) <= pivot) {
                s++;
                continue;
            } else {
                temp = list.get(s);
                list.set(s,list.get(e));
                list.set(e, temp);
                e--;
            }
        }
        if (list.get(s) <= pivot) {
            s++;
            e++;
        }
        list.set(end, list.get(s));
        list.set(s, pivot);

        quickSort(start, s-1);
        quickSort(s, end);
    }

    private void init() {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();

        num = sc.nextInt();
        for (int i=0;i<num;i++) {
            list.add(sc.nextInt());
        }
    }
}
