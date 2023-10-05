package com.example.codingtest.simulation.problem4;

import java.util.Arrays;

public class SeatProblem {

    public static void main(String[] args){
        SeatProblem T = new SeatProblem();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }

    private int[][] map;
    private int[][] direction;
    private int[] cur;
    private int directionIndex;
    public int[] solution(int c, int r, int k){
        if (c*r < k) {
            return new int[]{0,0};
        }

        int[] answer = new int[2];
        Boolean prev = false;
        int count = 1;
        init(c,r);
        map[1][1] = 1;

        while(true) {
            if (count == k) {
                break;
            }
            int y = cur[0] + direction[directionIndex][0];
            int x = cur[1] + direction[directionIndex][1];

            if (y < 1 || y > r || x < 1 || x > c || map[y][x] != 0) {
                directionIndex = (directionIndex + 1) % 4;
                if (prev) {
                    cur[0] = 0;
                    cur[1] = 0;
                    break;
                }
                prev = true;
                continue;
            }
            count++;
            cur[0] = y;
            cur[1] = x;
            map[y][x] = 1;
            prev = false;
        }
        answer[0] = cur[1];
        answer[1] = cur[0];
        return answer;
    }

    private void init(int c, int r) {
        map = new int[r+1][c+1];
        direction = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        directionIndex = 0;
        cur = new int[]{1,1};
    }
}
