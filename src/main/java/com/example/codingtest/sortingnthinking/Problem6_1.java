package com.example.codingtest.sortingnthinking;

public class Problem6_1 {
    public int solution(int[] tasks, long k) {
        int answer = 0;
        int index = 0;

        for (int i = 0; i<k; i++) {
            tasks[index++]--;

            if (index == tasks.length) {
                index = 0;
            }
            while (tasks[index] == 0) {
                index++;
                if (index == tasks.length) {
                    index = 0;
                }
            }
        }
        answer = index + 1;
        return answer;
    }

    public static void main(String[] args){
        Problem6_1 T = new Problem6_1();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }

}
