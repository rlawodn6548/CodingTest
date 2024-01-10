package com.example.codingtest.graph;

import java.util.*;

public class Problem2 {

    private Map<Integer, List<Integer>> stations;
    private int[] noe;
    private Queue<int[]> queue;

    public int solution(int[][] routes, int s, int e){
        int answer = 0;

        init(routes, s);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                int[] poll = queue.poll();
                List<Integer> stationList = stations.get(poll[0]);
                for (Integer station : stationList) {
                    for (int route : routes[station]) {
                        if (noe[route] > poll[1]) {
                            noe[route] = poll[1];
                            queue.add(new int[]{route, poll[1]+1});
                        }
                    }
                }
            }
            if (noe[e] != Integer.MAX_VALUE) {
                return noe[e];
            }
        }

        return answer;
    }

    private void init(int[][] routes, int s) {
        stations = new HashMap<>();
        int max = 0;
        for (int i = 0 ; i < routes.length; i++) {
            for (int elem : routes[i]) {
                if (!stations.containsKey(elem)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    stations.put(elem, list);
                }
                List<Integer> station = stations.get(elem);
                station.add(i);
                if (max < elem) {
                    max = elem;
                }
            }
        }
        noe = new int[max + 1];
        Arrays.fill(noe, Integer.MAX_VALUE);
        queue = new LinkedList<>();
        queue.add(new int[]{s,0});
    }

    public static void main(String[] args){
        Problem2 T = new Problem2();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
