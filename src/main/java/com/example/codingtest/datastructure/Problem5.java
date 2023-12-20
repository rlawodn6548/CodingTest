package com.example.codingtest.datastructure;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem5 {

    public static void main(String[] args){
        Problem5 T = new Problem5();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }


    private PriorityQueue<Task> taskQ;
    private PriorityQueue<Task> waitQ;
    private int curT;
    private int index;

    public int[] solution(int[][] tasks){
        int[] answer = new int[tasks.length];

        init(tasks);

        while (!taskQ.isEmpty() || !waitQ.isEmpty()) {
            if (waitQ.isEmpty()) {
                Task task = taskQ.poll();
                waitQ.add(task);
                curT = task.getStart();
            }
            Task task = waitQ.poll();
            curT += task.getDuration();
            answer[index++] = task.getIndex();

            while (!taskQ.isEmpty()) {
                if (taskQ.peek().getStart() <= curT) {
                    waitQ.add(taskQ.poll());
                } else {
                    break;
                }
            }
        }

        return answer;
    }

    private void init(int[][] tasks) {
        taskQ = new PriorityQueue<>((a, b) -> {
            if (a.getStart() <= b.getStart()) {
                return -1;
            } else {
                return 1;
            }
        });
        waitQ = new PriorityQueue<>((a, b) -> {
            if (a.getDuration() < b.getDuration()) {
                return -1;
            } else if (a.getDuration() == b.getDuration()) {
                if (a.getIndex() < b.getIndex()) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });
        curT = 0;
        index = 0;

        for (int i=0; i < tasks.length; i++) {
            Task task = new Task();
            task.setIndex(i);
            task.setStart(tasks[i][0]);
            task.setDuration(tasks[i][1]);
            taskQ.add(task);
        }
    }

    @Getter
    @Setter
    class Task {
        private int index;
        private int start;
        private int duration;
    }
}
