package com.example.codingtest.baekjoon.type.graph.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N24444 {
    public static void main(String[] args) {
        N24444 n24444 = new N24444();
        n24444.init();
        n24444.calculate();
    }

    private int visitCnt;
    private int[] visited;
    private int startNode;
    private List<TreeSet<Integer>> graph;
    private Queue<Integer> queue;

    public void init() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            int edgeNum = Integer.parseInt(st.nextToken());
            startNode = Integer.parseInt(st.nextToken());
            visitCnt = 1;
            visited = new int[nodeNum+1];
            queue = new LinkedList<>();
            graph = new ArrayList<>();

            for (int i=0; i<=nodeNum; i++) {
                graph.add(new TreeSet<>());
            }
            for (int i=0; i<edgeNum; i++) {
                st = new StringTokenizer(bf.readLine());
                int elem1 = Integer.parseInt(st.nextToken());
                int elem2 = Integer.parseInt(st.nextToken());

                graph.get(elem1).add(elem2);
                graph.get(elem2).add(elem1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void calculate() {
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();

            if (visited[currentNode] != 0) {
                continue;
            }
            visited[currentNode] = visitCnt++;

            for (int node : graph.get(currentNode)) {
                if (visited[node] == 0) {
                    queue.add(node);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<graph.size(); i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}
