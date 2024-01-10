package com.example.codingtest.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {

    private Queue<int[]> queue;
    private int[][] min;
    private int[][] direction;

    public int solution(int[][] board) {
        int answer = 0;

        init(board);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] poll = queue.poll();
                int y = poll[0];
                int x = poll[1];
                int count = poll[2];

                for (int[] dir : direction) {
                    int moveX = x+dir[1];
                    int moveY = y+dir[0];
                    if (moveX >=0 && moveX < board[0].length && moveY >=0 && moveY < board.length) {
                        int temp = count;
                        if (board[moveY][moveX] == 1) {
                            temp++;
                        }
                        if (min[moveY][moveX] > temp) {
                            min[moveY][moveX] = temp;
                            queue.add(new int[]{moveY, moveX, temp});
                        }
                    }
                }
            }
        }

        answer = min[board.length-1][board[0].length-1];
        return answer;
    }

    private void init(int[][] board) {
        queue = new LinkedList<>();
        direction = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        min = new int[board.length][board[0].length];
        for (int[] elem : min) {
            Arrays.fill(elem, Integer.MAX_VALUE);
        }
        min[0][0] = 0;
        queue.add(new int[]{0,0,0});
    }

    public static void main(String[] args){
        Problem3 T = new Problem3();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0},{1, 1, 0, 1},{0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1},{0, 1, 1, 1, 1, 1},{1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 1, 1, 1},{1, 1, 0, 0, 1, 1, 1},{1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 1, 1, 0}}));
    }
}
