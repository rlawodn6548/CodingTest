package com.example.codingtest.sortingnthinking;

public class Problem6 {
    public int solution(int[] tasks, long k) {
        int answer = 0;

        for (int i = 0; i <= k; i++) {
            if (tasks[answer] == 0) {
                i--;
            } else {
                if (i == k) {
                    break;
                }
                tasks[answer]-=1;
            }
            answer++;
            if (answer == tasks.length) {
                answer = 0;
            }
        }

        return answer +1;
    }

    public static void main(String[] args){
        Problem6 T = new Problem6();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}
