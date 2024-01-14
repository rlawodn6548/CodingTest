package com.example.codingtest.dfs;

import java.util.ArrayList;
import java.util.List;

public class Problem2_1 {
    private int n;
    private List<List<Integer>> fightList;
    private boolean[] used;
    private int count;

    public int solution(int[][] fight){
        int answer = 0;
        init(fight);

        int[] cur = new int[n];
        dfs(cur, 1, 0);

        answer = count;
        return answer;
    }

    private void dfs(int[] cur, int depth, int prev) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 1; i < n; i++) {
            if (used[i] || fightList.get(i).contains(prev)) {
                continue;
            }
            used[i] = true;
            cur[depth] = i;
            dfs(cur, depth+1, i);
            used[i] = false;
        }
    }

    private void init(int[][] fight) {
        n = 8;
        fightList = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            fightList.add(new ArrayList<>());
        }
        count = 0;
        used = new boolean[n];

        for (int[] elem : fight) {
            fightList.get(elem[0]).add(elem[1]);
            fightList.get(elem[1]).add(elem[0]);
        }
    }

    public static void main(String[] args){
        Problem2_1 T = new Problem2_1();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
