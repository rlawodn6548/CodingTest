package com.example.codingtest.sortingnthinking;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1 {

    public static void main(String[] args){
        Problem1 T = new Problem1();
        long start = System.nanoTime();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
        System.out.println(Arrays.toString(T.solution(new int[]{55, 85,52,36,98,2,31,622,35,949,12, 5, 7, 23, 45, 21, 17})));
        long end = System.nanoTime();
        System.out.println("수행시간: " + (end - start) + " n/s");
    }

    private int[][] numberOfOne;

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];

        init(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 0;

            while (num > 0) {
                count += num%2;
                num = num/2;
            }
            numberOfOne[i][0] = nums[i];
            numberOfOne[i][1] = count;
        }
        Arrays.sort(numberOfOne, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int index = 0;
        for(int i = 0; i < numberOfOne.length; i++){
            answer[i] = numberOfOne[i][0];
        }

        return answer;
    }

    private void init(int[] nums) {
        numberOfOne = new int[nums.length][2];
    }

}
