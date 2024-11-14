package com.example.codingtest.baekjoon.type.search.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1920 {
    private List<Integer> list;

    public static void main(String[] args) throws IOException {
        P1920 main = new P1920();
        main.search();
    }

    private void search() throws IOException {
        list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<n;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<m;i++) {
            binarySearch(Integer.parseInt(st.nextToken()));
        }
    }

    private void binarySearch(int finder) {
        int s = 0;
        int e = list.size()-1;

        while (s <= e) {
            int index = (s+e)/2;
            if (list.get(index) == finder) {
                System.out.println(1);
                return;
            }
            if (list.get(index) > finder) {
                e = index -1;
            } else {
                s = index+1;
            }
        }
        System.out.println(0);
    }

    public void useAPI(int finder){
        // ArrayList의 contains()의 경우 선형탐색을 사용하기 때문에 List의 크기가 클수록 성능이 안좋다(log(n))
        if (list.contains(finder)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
