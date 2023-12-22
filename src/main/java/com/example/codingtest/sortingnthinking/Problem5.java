package com.example.codingtest.sortingnthinking;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem5 {

    private ArrayList<Integer> rawArray;
    private ArrayList<Integer> colArray;
    private int[] meeting;
    private int number;

    public int solution(int[][] board){
        int answer=0;

        init(board);

        for (int raw = 0; raw < board.length; raw++) {
            for (int col = 0; col < board.length; col++) {
                if (board[raw][col] == 1) {
                    rawArray.add(raw);
                    colArray.add(col);
                    number++;
                }
            }
        }

        colArray.sort((a,b) -> a-b);
        meeting[0] = rawArray.get(number/2);
        meeting[1] = colArray.get(number/2);

        for (int i=0 ; i<number; i++) {
            answer += Math.abs(rawArray.get(i) - meeting[0]);
            answer += Math.abs(colArray.get(i) - meeting[1]);
        }

        return answer;
    }

    private void init(int[][] board) {
        rawArray = new ArrayList<>();
        colArray = new ArrayList<>();
        meeting = new int[2];
        number = 0;
    }

    public static void main(String[] args){
        Problem5 T = new Problem5();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
