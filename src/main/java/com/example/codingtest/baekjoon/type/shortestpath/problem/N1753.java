package com.example.codingtest.baekjoon.type.shortestpath.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1753 {
    public static void main(String[] args) throws IOException {
        N1753 n1753 = new N1753();
        n1753.initializeGraph();
        n1753.findShortestPaths();
    }

    private List<List<Edge>> graph;
    private int numNodes;
    private int numEdges;
    private int startNode;

    public void initializeGraph() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        numNodes = Integer.parseInt(stringTokenizer.nextToken());
        numEdges = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        startNode = Integer.parseInt(stringTokenizer.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i<= numNodes; i++) {
           graph.add(new ArrayList<>());
        }

        for (int i = 0; i< numEdges; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, value));
        }
    }

    public void findShortestPaths() {
        final int INF = Integer.MAX_VALUE;
        int[] distances = new int[numNodes + 1];
        Arrays.fill(distances, INF);
        distances[startNode]=0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(startNode,0));

        while (!queue.isEmpty()) {
            Edge current = queue.poll();

            if (current.value > distances[current.key]) {
                continue;
            }

            for (Edge edge : graph.get(current.key)) {
                int newDistance = distances[current.key] + edge.value;
                if (distances[edge.key] > newDistance) {
                    distances[edge.key] = newDistance;
                    queue.add(new Edge(edge.key, newDistance));
                }
            }
        }

        for (int i = 1; i<= numNodes; i++) {
            if (distances[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distances[i]);
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        private final int key;
        private final int value;

        public Edge(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(value, o.value);
        }
    }
}
