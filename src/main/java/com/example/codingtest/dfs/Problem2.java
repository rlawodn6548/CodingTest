package com.example.codingtest.dfs;

import java.util.*;

public class Problem2 {

    private int[] check;
    private int answer;
    private Map<Integer, List<Integer>> fightMap;

    public int solution(int[][] fight){
        init(fight);

        dfs(0, 0);

        return answer;
    }

    private void dfs(int depth, int prev) {
        if (depth == 7) {
            answer++;
            return;
        }

        for (int i=1; i<=7; i++) {
            if (check[i] == 0 && !fightMap.get(i).contains(prev)) {
                check[i] = 1;
                dfs(depth+1, i);
                check[i] = 0;
            }
        }
    }

    private void init(int[][] fight) {
        answer = 0;
        check = new int[8];
        fightMap = new HashMap<>();
        for (int i=1; i<=7; i++) {
            fightMap.put(i, new ArrayList<>());
        }
        for (int[] elem : fight) {
            List<Integer> firstList = fightMap.get(elem[0]);
            firstList.add(elem[1]);
            List<Integer> secondList = fightMap.get(elem[1]);
            secondList.add(elem[0]);
        }
    }

    public static void main(String[] args){
        Problem2 T = new Problem2();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
