package com.example.codingtest.baekjoon.type.graph.problem;

import java.io.*;
import java.util.*;

public class N1260 {
    private List<List<Integer>> graph;
    private int nodeNumber;
    private int startNode;

    public static void main(String[] args) {
        N1260 n1260 = new N1260();
        n1260.solve();
    }

    public N1260() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            nodeNumber = Integer.parseInt(tokenizer.nextToken());
            int edgeNumber = Integer.parseInt(tokenizer.nextToken());
            startNode = Integer.parseInt(tokenizer.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= nodeNumber; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < edgeNumber; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                int u = Integer.parseInt(tokenizer.nextToken());
                int v = Integer.parseInt(tokenizer.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            // 인접 리스트의 각 리스트를 정렬하여 탐색 순서를 보장
            for (List<Integer> edges : graph) {
                Collections.sort(edges);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void solve() {
        boolean[] visited = new boolean[nodeNumber + 1];
        dfs(startNode, visited);
        System.out.println();

        visited = new boolean[nodeNumber + 1];
        bfs(startNode, visited);
    }

    private void dfs(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    private void bfs(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}