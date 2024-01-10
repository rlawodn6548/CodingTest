package com.example.codingtest.graph;

import java.util.*;

public class Problem1 {

    private Queue<int[]> queue;
    private List<List<int[]>> graph;
    private int[] costs;

    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;
        init(n,s, flights);
        int depth = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0 ; i< len ; i++) {
                int[] poll = queue.poll();
                int now = poll[0];
                int nowCost = poll[1];
                for (int[] elem : graph.get(now)) {
                    int to = elem[0];
                    int toCost = elem[1];
                    if (nowCost + toCost <costs[to]) {
                        costs[to] = nowCost + toCost;
                        queue.add(new int[]{to, costs[to]});
                    }
                }
            }
            depth++;
            if (depth > k) {
                break;
            }

        }
        if (costs[e] == Integer.MAX_VALUE) {
            return -1;
        }
        answer = costs[e];
        return answer;
    }

    private void init(int n, int s, int[][] flights) {
        graph = new ArrayList<>();
        for (int i = 0 ; i<n; i++ ){
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);

        queue = new LinkedList<>();
        queue.add(new int[]{s, 0});
    }


    public static void main(String[] args){
        Problem1 T = new Problem1();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
