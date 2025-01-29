package com.example.codingtest.baekjoon.type.graph.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N14940 {
    public static void main(String[] args) {
        N14940 n14940 = new N14940();
        n14940.init();
        n14940.search();
    }

    private int n, m;
    private Queue<int[]> queue;
    private int[][] direction;
    private int[][] graph;

    public void init() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            direction = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
            queue = new LinkedList<>();
            graph = new int[n+1][m+1];

            for (int i=1; i<=n;i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j=1; j<=m;j++) {
                    int index = Integer.parseInt(st.nextToken());
                    if (index == 1) {
                        graph[i][j] = -1;
                    } else if (index ==2) {
                        queue.add(new int[]{i,j,0});
                        graph[i][j] = 0;
                    } else {
                        graph[i][j] = index;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void search() {
        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();

            for (int[] dir : direction) {
                int nodeN = currentNode[0] + dir[0];
                int nodeM = currentNode[1] + dir[1];

                if (nodeN <= n && nodeM <=m && nodeN > 0 && nodeM > 0) {
                    if (graph[nodeN][nodeM] == -1 || currentNode[2]+1 < graph[nodeN][nodeM]) {
                        graph[nodeN][nodeM] = currentNode[2]+1;
                        queue.add(new int[]{nodeN, nodeM, currentNode[2]+1});
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            for (int j=1;j<=m;j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
