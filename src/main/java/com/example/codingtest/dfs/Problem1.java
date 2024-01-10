package com.example.codingtest.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1 {
    private int target;
    private List<Integer> sortedList;
    private int[] checkBox;
    private int answer;
    private boolean flag;

    public int solution(int n){
        init(n);

        dfs(0, 0);
        if (answer == 0) {
            return -1;
        }
        return answer;
    }

    private void dfs(int depth, int value) {
        if (flag) {
            return;
        }
        if (depth == sortedList.size()) {
            if (value > target) {
                answer = value;
                flag = true;
                return;
            }
        }

        for (int i = 0; i < sortedList.size(); i++) {
            if (checkBox[i] == 0) {
                int temp = sortedList.get(i);
                checkBox[i] = 1;
                temp = value * 10 + temp;
                dfs(depth + 1, temp);
                checkBox[i] = 0;
            }
        }
    }

    private void init(int n) {
        target = n;
        sortedList = new ArrayList<>();
        int tmp = n;
        while (tmp > 0) {
            sortedList.add(tmp%10);
            tmp/=10;
        }
        sortedList.sort((a, b) -> a-b);
        checkBox = new int[sortedList.size()];
        answer = 0;
        flag = false;
    }


    public static void main(String[] args){
        Problem1 T = new Problem1();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
