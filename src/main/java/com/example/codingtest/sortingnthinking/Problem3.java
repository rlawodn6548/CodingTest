package com.example.codingtest.sortingnthinking;

import java.util.Arrays;

public class Problem3 {
    private Integer[] diffArray;
    private Integer[] numbers;

    public int solution(int[] nums, int k){
        int answer = 0;

        init(nums);

        Arrays.sort(numbers, (a,b) -> b-a );
        for (int i=0; i<numbers.length; i+=2) {
            answer += numbers[i+1];
            diffArray[i/2] = numbers[i] - numbers[i+1];
        }
        Arrays.sort(diffArray, (a, b) -> b-a);
        for (int i = 0; i < k; i++) {
            answer += diffArray[i];
        }

        return answer;
    }

    private void init(int[] nums) {
        diffArray = new Integer[nums.length/2];
        numbers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    }

    public static void main(String[] args){
        Problem3 T = new Problem3();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }

}
