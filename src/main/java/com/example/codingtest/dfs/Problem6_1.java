package com.example.codingtest.dfs;

public class Problem6_1 {
    private int cnt;
    public int solution(String s){
        cnt = 0;
        dfs(s);
        return cnt;
    }

    private void dfs(String s) {
        if (s.isEmpty()) {
            cnt++;
            return;
        }

        for (int i = 1; i <= 2; i++) {
            if (s.length() < i) {
                return;
            }
            String substring = s.substring(0, i);
            if (substring.startsWith("0")) {
                if (i >1) {
                    continue;
                }
            }
            int value = Integer.parseInt(substring);
            if (value > 0 && value <27) {
                dfs(s.substring(i));
            }
        }
    }

    public static void main(String[] args){
        Problem6_1 T = new Problem6_1();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
