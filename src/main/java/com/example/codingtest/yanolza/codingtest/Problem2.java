package com.example.codingtest.yanolza.codingtest;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    public int[] solution(int[][] coords, int[][] query) {
        int[] answer = new int[query.length];
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int[] coord : coords) {
            if (minX > coord[0]) {
                minX = coord[0];
            }
            if (maxX < coord[0]) {
                maxX = coord[0];
            }
            if (minY > coord[1]) {
                minY = coord[1];
            }
            if (maxY < coord[1]) {
                maxY = coord[1];
            }
        }
        int[] index = new int[]{minX, maxY};

        for (int[] coord :coords) {
            int[] newCoord = move(coord, index);
            int coordX = newCoord[0];
            int coordY = newCoord[1];

            Map<Integer, Integer> inner = map.getOrDefault(coordY, new HashMap<>());
            inner.putIfAbsent(coordX, 1);
            map.putIfAbsent(coordY, inner);
        }
        maxX = maxX - minX;
        maxY = maxY - minY;

        for (int i = 0; i <query.length; i++) {
            int[] q = query[i];

            if (q[0] < 0 || q[1] < 0 || q[0] > maxY|| q[1] > maxX) {
                answer[i]=-1;
                continue;
            }

            if (map.containsKey(q[0])) {
                Map<Integer, Integer> inner = map.get(q[0]);
                if (inner.containsKey(q[1])) {
                    answer[i]=1;
                } else {
                    answer[i]=0;
                }
            }
        }

        return answer;
    }

    private int[] move(int[] coord, int[] index) {
        int coordX = Math.abs(coord[0] - index[0]);
        int coordY = Math.abs(coord[1] - index[1]);
        return new int[]{coordX, coordY};
    }
    public static void main(String[] args){
        Problem2 T = new Problem2();
        System.out.println(T.solution(new int[][]{{-3, -3}, {4, 3}, {2,1}}, new int[][]{{0,7}, {4,8}, {5,2}, {2,5},{6,0}, {-3,-3}}));

    }
}
