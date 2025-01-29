package com.example.codingtest.datastructure;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem5_1 {
    private PriorityQueue<int[]> waitQueue;
    private PriorityQueue<int[]> taskQueue;

    public int[] solution(int[][] tasks){
        int[] answer = new int[tasks.length];
        int curTime = 0;
        int answerIdx = 0;
        init(tasks);

        while (!waitQueue.isEmpty() || !taskQueue.isEmpty()) {
            while (!taskQueue.isEmpty() && taskQueue.peek()[0] <= curTime) {
                int[] poll = taskQueue.poll();
                waitQueue.add(poll);
            }

            int[] poll = waitQueue.poll();
            if (poll == null) {
                curTime = taskQueue.peek()[0];
            } else {
                curTime += poll[1];
                answer[answerIdx++] = poll[2];
            }
        }

        return answer;
    }

    private void init(int[][] tasks) {
        waitQueue = new PriorityQueue<>((a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            } else if (a[1] == b[1]){
                if (a[2] < b[2]) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });

        taskQueue = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) {
                return -1;
            } else {
                return 1;
            }
        });
        for (int i = 0 ; i<tasks.length; i++) {
            int[] elem = new int[3];
            elem[0] = tasks[i][0];
            elem[1] = tasks[i][1];
            elem[2] = i;
            taskQueue.add(elem);
        }
    }

    public static void main(String[] args){
        Problem5_1 T = new Problem5_1();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}
