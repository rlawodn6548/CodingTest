package com.example.codingtest.simulation.problem7;

import java.util.Arrays;

public class Password {
    public static void main(String[] args){
        Password T = new Password();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }

    private int[][] board;
    private int[][] dist;
    private int[] passwd;
    private int[][] direction;

    public int solution(int[] keypad, String password){
        int answer = 0;
        init(keypad, password);

        for (int i=1; i<passwd.length; i++) {
            answer += dist[passwd[i-1]][passwd[i]];
        }

        return answer;
    }

    private void init(int[] keypad, String password) {
        passwd = new int[password.length()];
        for (int i = 0; i< password.length(); i++) {
            passwd[i] = (int)password.charAt(i) - 48;
        }

        board = new int[3][3];
        int index = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                board[i][j] = keypad[index++];
            }
        }

        direction = new int[][]{{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};

        dist = new int[11][11];
        for (int i=1; i<11; i++) {
            Arrays.fill(dist[i], 2);
        }
        for (int i=1; i<11; i++) {
            dist[i][i] = 0;
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                for (int dir = 0; dir < direction.length; dir++) {
                    if (i + direction[dir][0] < 0 || i +direction[dir][0] > 2 || j + direction[dir][1] < 0 || j + direction[dir][1] > 2) {
                        continue;
                    }
                    int from = board[i][j];
                    int to = board[i + direction[dir][0]][j + direction[dir][1]];

                    dist[from][to] = 1;
                }
            }
        }

    }
}
