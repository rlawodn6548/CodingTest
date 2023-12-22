package com.example.codingtest.sortingnthinking;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem7 {

    public int solution(int[][] meetings){
        int answer = 0;
        int cnt=0;
        ArrayList<int[]> list = new ArrayList<>();

        for (int[] meeting : meetings) {
            list.add(new int[]{meeting[0], 0});
            list.add(new int[]{meeting[1], 1});
        }

        list.sort((a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        for (int[] elem : list) {
            if (elem[1] == 0) {
                cnt++;
                if (answer < cnt) {
                    answer = cnt;
                }
            } else {
                cnt--;
            }
        }


        return answer;
    }

    public static void main(String[] args){
        Problem7 T = new Problem7();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
