package com.example.codingtest.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5_1 {
    private List<String> answerList;
    public String[] solution(String s){
        String[] answer = {};
        answerList = new ArrayList<>();

        dfs(s,new String[4],1);
        answer = new String[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private void dfs(String s, String[] elem, int depth) {
        if (depth == 5) {
            if (s.isEmpty()) {
                String ip = "";
                for (String subs : elem) {
                    ip += subs;
                    ip +=".";
                }
                answerList.add(ip.substring(0, ip.length()-1));
            }
            return;
        }

        for (int i = 1 ; i <= 3; i++) {
            if (s.length() < i) {
                continue;
            }
            String substring = s.substring(0, i);
            if (substring.startsWith("0")) {
                if (i >1) {
                    continue;
                }
            }
            int value = Integer.parseInt(substring);
            if (value > 255) {
                continue;
            }
            elem[depth-1] = substring;
            dfs(s.substring(i), elem, depth+1);
        }
    }

    public static void main(String[] args){
        Problem5_1 T = new Problem5_1();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
