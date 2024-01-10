package com.example.codingtest.dfs;

public class Problem6 {
    private int answer;

    public int solution(String s){
        answer = 0;

        dfs(0, 0, s);

        return answer;
    }

    private void dfs(int depth, int start, String s) {
        if (start >= s.length()) {
            answer++;
            return;
        }

        for (int i=1; i<3;i++) {
            if (start + i >s.length()) {
                break;
            }
            int subNumber = Integer.parseInt(s.substring(start, start + i));
            if (subNumber ==0 && i !=0) {
                return ;
            }
            if (subNumber <27) {
                dfs(depth+1, start + i, s);
            }
        }
    }

    public static void main(String[] args){
        Problem6 T = new Problem6();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }

}
