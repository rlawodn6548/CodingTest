package com.example.codingtest.baekjoon.type.bruteforce.problem;

import java.util.Scanner;

public class P1018 {
    private int n;
    private int m;
    private int[][] board; // W =1 ,B = 0

    public static void main(String[] args) {
        P1018 main = new P1018();
        main.init();
        main.calculate();
    }

    private int calculate() {
        int min = Integer.MAX_VALUE;
        for (int i=0;i<=n-8;i++) {
            for (int j=0; j<=m-8;j++) {
                int cnt = count(i,j,0,min);
                min = Math.min(min, cnt);
                cnt = count(i,j,1,min);
                min = Math.min(min, cnt);
            }
        }
        System.out.println("min = " + min);
        return min;
    }

    private int count(int startI, int startJ, int color, int min) {
        int cur = color;
        int cnt = 0;

        for (int i=startI; i<startI+8; i++) {
            for (int j=startJ;j<startJ+8;j++) {
                if (board[i][j] != cur) {
                    cnt++;
                    if (min < cnt) {
                        return min;
                    }
                }
                cur = cur ==0?1:0;
            }
            cur= cur==0?1:0;
        }
        return cnt;
    }

    private void init() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];

        for (int i=0; i<n; i++) {
            String next = sc.next();
            for (int j=0; j<m;j++) {
                if (next.charAt(j) == 'W') {
                    board[i][j] = 1;
                } else {
                    board[i][j]=0;
                }
            }
        }
    }


}
