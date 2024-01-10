package com.example.codingtest.graph;

import java.util.*;

public class Problem1_1 {
    private List<List<int[]>> flightList;
    private int[] minimum;
    private Queue<int[]> queue;

    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;
        init(n, flights, s);
        int depth = 0;

        while (!queue.isEmpty()) {
            if (depth == k + 1) {
                break;
            }
            int len = queue.size();
            for (int i = 0 ; i < len; i++) {
                int[] poll = queue.poll();
                for (int[] flight : flightList.get(poll[0])) {
                    int cost = poll[1] + flight[1];
                    if (cost < minimum[flight[0]]) {
                        minimum[flight[0]] = cost;
                        queue.add(new int[]{flight[0], cost});
                    }
                }
            }
            depth++;
        }
        answer = minimum[e] == Integer.MAX_VALUE? -1 : minimum[e];
        return answer;
    }

    private void init(int n, int[][] flights, int start) {
        flightList = new ArrayList<>();
        minimum = new int[n];
        queue = new LinkedList<>();

        Arrays.fill(minimum, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            flightList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            List<int[]> elem = flightList.get(flight[0]);
            elem.add(new int[]{flight[1], flight[2]});
        }
        queue.add(new int[]{start, 0});
    }

    public static void main(String[] args){
        Problem1_1 T = new Problem1_1();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
        System.out.println(T.solution(4, new int[][]{{0, 3, 59},{2, 0, 83}, {3, 1, 16}, {1, 3, 16}}, 3, 0, 3));
    }
}
