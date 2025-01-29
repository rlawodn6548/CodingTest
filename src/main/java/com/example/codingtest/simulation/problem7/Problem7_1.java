package com.example.codingtest.simulation.problem7;

import java.util.Arrays;

public class Problem7_1 {
    private int[][] distArray;
    private int[][] keypadArray;
    private int[][] direct;

    public int solution(int[] keypad, String password){
        int answer = 0;
        init();

        for (int i=1 ; i < 10; i++) {
            for (int j=1; j<10; j++) {
                if (i==j) {
                    distArray[i][j]=0;
                } else {
                    distArray[i][j]=2;
                }
            }
        }
        int index = 0;
        for (int j = 1; j<=3; j++) {
            for (int k=1; k <=3; k++) {
                keypadArray[j][k] = keypad[index++];
            }
        }

        for (int curx=1; curx <4; curx++) {
            for (int cury=1; cury <4; cury++) {
                for (int[] dir : direct) {
                    if (curx + dir[1] <1 || curx+dir[1] >3 || cury+dir[0] <1 || cury+dir[0] >3) {
                        continue;
                    }
                    int curValue = keypadArray[cury][curx];
                    int targetValue = keypadArray[cury+dir[0]][curx+dir[1]];
                    distArray[curValue][targetValue]=1;
                }
            }
        }


        for (int i = 0 ; i<password.length()-1; i++) {
            int curNum = (int)password.charAt(i) - 48;
            int nextNum = (int)password.charAt(i+1) - 48;

            answer+=distArray[curNum][nextNum];
        }

        return answer;
    }

    private void init() {
        distArray = new int[10][10];
        keypadArray = new int[4][4];
        direct = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    }

    public static void main(String[] args){
        Problem7_1 T = new Problem7_1();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
