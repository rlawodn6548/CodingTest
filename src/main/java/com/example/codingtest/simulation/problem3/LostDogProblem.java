package com.example.codingtest.simulation.problem3;

public class LostDogProblem {
    Creature h = null;
    Creature dog = null;

    public static void main(String[] args){
        LostDogProblem T = new LostDogProblem();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
        int[][] arr3 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 1, 3}};
        System.out.println(T.solution(arr3));
    }

    public int solution(int[][] board){
        int answer = 0;
        init(board);

        for (int i = 0 ; i <10000 ; i++) {
            h.move(board);
            dog.move(board);

            if (h.getIndex()[0] == dog.getIndex()[0] && h.getIndex()[1] == dog.getIndex()[1]) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }

    public void init(int[][] board){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 2) {
                    h = new Creature(j, i);
                } else if (board[i][j] == 3) {
                    dog = new Creature(j, i);
                }
            }
        }
    }

    class Creature {
        private int[] index;
        private int[][] direction;
        private int directionIndex;

        public Creature(int x, int y) {
            index = new int[2];
            index[0] = x;
            index[1] = y;
            direction = new int[][] {{0,-1}, {1,0}, {0,1}, {-1,0}};
            directionIndex = 0;
        }

        public void move(int[][] board) {
            int[] movingDirection = direction[directionIndex];
            int x = index[0] + movingDirection[0];
            int y = index[1] + movingDirection[1];

            if ( x < 0 || x >= 10 || y < 0 || y >= 10 || board[y][x] == 1) {
                directionIndex = (directionIndex + 1) % 4;
                return;
            }

            index[0] = x;
            index[1] = y;
        }

        public int[] getIndex() {
            return index;
        }
    }
}
