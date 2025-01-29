package com.example.codingtest.baekjoon.type.heap.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N11279 {
    public static void main(String[] args) {
        N11279 n11279 = new N11279();
        n11279.initPriorityQueue();
        n11279.executeOrder();
    }

    private PriorityQueue<Integer> pq;

    public void initPriorityQueue() {
        pq = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void executeOrder() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            int numOrders = Integer.parseInt(bf.readLine());

            for (int i=0;i<numOrders;i++) {
                int order = Integer.parseInt(bf.readLine());

                if (order == 0) {
                    System.out.println(pq.isEmpty() ? "0" : pq.poll());
                } else {
                    pq.add(order);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
