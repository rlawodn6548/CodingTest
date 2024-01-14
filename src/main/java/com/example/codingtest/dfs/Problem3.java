package com.example.codingtest.dfs;

public class Problem3 {
    private int n;
    private boolean[] used;
    private int minDiff;


    public int solution(int[][] cans){
        int answer = 0;
        init(cans);

        dfs(cans, 1, 0, 0 ,0, 0);

        answer = minDiff;
        return answer;
    }

    private void dfs(int[][] cans, int depth, int blackTeamTotal, int whiteTeamTotal, int blackTeamNum, int whiteTeamNum) {
        if (depth == n) {
            minDiff = Math.min(minDiff, Math.abs(whiteTeamTotal - blackTeamTotal));
            return;
        }
        for (int i = 1; i < n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (blackTeamNum < n/2) {
                dfs(cans, depth + 1, blackTeamTotal + cans[i - 1][1], whiteTeamTotal, blackTeamNum + 1, whiteTeamNum);
            }
            if (whiteTeamNum < n/2) {
                dfs(cans, depth + 1, blackTeamTotal, whiteTeamTotal + cans[i - 1][0], blackTeamNum, whiteTeamNum + 1);
            }
            used[i] = false;
        }
    }

    private void init(int[][] cans) {
        n = cans.length + 1;
        used = new boolean[n];
        minDiff = Integer.MAX_VALUE;
    }

    public static void main(String[] args){
        Problem3 T = new Problem3();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}
