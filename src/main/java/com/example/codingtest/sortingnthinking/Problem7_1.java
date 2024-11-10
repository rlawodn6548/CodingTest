package com.example.codingtest.sortingnthinking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7_1 {
    private List<int[]> meetingList;
    public int solution(int[][] meetings){
        int answer = 0;
        init(meetings);

        for (int i=0 ; i<meetingList.size();i++) {
            int needs = 1;

            int[] target = meetingList.get(i);
            for (int j=0; j < i; j++) {
                int[] compare = meetingList.get(j);

                if (target[0] >= compare[0] && target[0] < compare[1]) {
                    needs++;
                }
            }
            answer = Math.max(answer, needs);
        }

        return answer;
    }

    private void init(int[][] meetings) {
        meetingList = new ArrayList<>();

        for (int i = 0; i < meetings.length; i++) {
            meetingList.add(meetings[i]);
        }
        Collections.sort(meetingList, (a,b) -> a[0] < b[0] ? -1 : 1);
    }

    public static void main(String[] args){
        Problem7_1 T = new Problem7_1();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}
