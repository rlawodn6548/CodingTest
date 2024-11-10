package com.example.codingtest.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem5 {
    private List<int[][]> mapList;
    private List<int[]> buildingIdxList;
    private int[][] dir;
    private Queue<int[]> queue;

    public int solution(int[][] board){
        init(board);

        for (int i=0; i<buildingIdxList.size(); i++) {
            int[][] distMap = mapList.get(i);
            int[] start = buildingIdxList.get(i);
            queue.add(new int[]{start[0], start[1], 0});

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                for (int[] di : dir) {
                    int x = poll[0] + di[0];
                    int y = poll[1] + di[1];
                    if (x >= 0 && x <board.length && y >= 0 && y <board.length && board[x][y] == 0) {
                        if (distMap[x][y] > poll[2]+1) {
                            distMap[x][y] = poll[2]+1;
                            queue.add(new int[]{x,y,poll[2]+1});
                        }
                    }
                }
            }
        }

        int[][] totalMap = new int[board.length][board.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < mapList.size(); k++) {
                    int[][] map = mapList.get(k);
                    if (map[i][j] == Integer.MAX_VALUE) {
                        totalMap[i][j]=-1;
                        break;
                    }
                    totalMap[i][j] += map[i][j];
                }
                if (totalMap[i][j] > 0) {
                    min = Math.min(min, totalMap[i][j]);
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }

    private void init(int[][] board) {
        mapList = new ArrayList<>();
        buildingIdxList = new ArrayList<>();
        queue = new LinkedList<>();
        dir = new int[][]{{1,0},{0,1}, {-1,0}, {0,-1}};

        int[][] distMap = new int[board.length][board.length];
        for (int i = 0; i <board.length; i++) {
            for (int j=0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    buildingIdxList.add(new int[]{i,j});
                    distMap[i][j]=-1;
                } else if (board[i][j] == 2) {
                    distMap[i][j]=-1;
                } else {
                    distMap[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        mapList.add(distMap);
        for (int i = 0; i<buildingIdxList.size()-1;i++) {
            int[][] clone = new int[board.length][board.length];
            for (int j=0; j<board.length; j++) {
                clone[j] = distMap[j].clone();
            }
            mapList.add(clone);
        }
    }

    public static void main(String[] args){
        Problem5 T = new Problem5();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
