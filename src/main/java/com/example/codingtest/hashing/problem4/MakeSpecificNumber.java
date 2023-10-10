package com.example.codingtest.hashing.problem4;

public class MakeSpecificNumber {
    public static void main(String[] args){
        MakeSpecificNumber T = new MakeSpecificNumber();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }

    public int solution(int[] nums, int m){
        int answer = 0;

        for (int i=0; i<nums.length; i++) {
            int sum =0;
            for (int j=i; j<nums.length; j++) {
                sum += nums[j];
                if (sum == m) {
                    answer++;
                }
            }
        }

        return answer;
    }


}
