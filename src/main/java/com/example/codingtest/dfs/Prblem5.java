package com.example.codingtest.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class Prblem5 {

    private ArrayList<Integer> list;
    private ArrayList<String> answer;
    public String[] solution(String s){
        String[] answer = {};

        init(s);

        dfs(0, 0);

        return answer;
    }

    private void dfs(int depth, int index) {


        int temp = 0;
        for (int i = 0 ; i < 3; i++) {
            if (list.get(index + 1) == 0) {

            }
            temp = temp * 10 + list.get(index + i);


        }
    }

    private void init(String s) {
        list = new ArrayList<>();
        answer = new ArrayList<>();

        for (int i = 0; i<s.length();i++) {
            list.add(Integer.parseInt(s.substring(i, i+1)));
        }
    }

    public static void main(String[] args){
        Prblem5 T = new Prblem5();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
