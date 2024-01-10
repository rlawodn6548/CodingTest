package com.example.codingtest.graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem5 {
    public int solution(int[][] board, int[] s, int[] e){
        int answer = 0;
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[2]- b[2]);
        queue.add(new int[]{s[0],s[1],0});

        int[][] minCost = new int[board.length][board[0].length];
        for (int[] minCostElem : minCost) {
            Arrays.fill(minCostElem, Integer.MAX_VALUE);
        }
        minCost[s[0]][s[1]] = 0;

        int[][] direction = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i= 0; i<4; i++) {
                int raw = poll[0] + direction[i][0];
                int col = poll[1] + direction[i][1];
                if (raw >= 0 && raw <board.length && col >= 0 && col <board[0].length && board[raw][col] != 1) {
                    if (minCost[raw][col] > poll[2] + 1) {
                        minCost[raw][col] = poll[2] +1;
                        queue.add(new int[]{raw,col, minCost[raw][col]});
                    }
                }
            }
        }

        if (minCost[e[0]][e[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        return minCost[e[0]][e[1]];
    }
    public static void main(String[] args){
        Problem5 T = new Problem5();
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{1, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 3}, new int[]{4, 2}));
        System.out.println(T.solution(new int[][]{{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 5}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[]{0, 0}, new int[]{4, 3}));
    }
}
