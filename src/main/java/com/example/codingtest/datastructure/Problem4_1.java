package com.example.codingtest.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class Problem4_1 {
    private Queue<int[]> waiting;
    private Queue<int[]> reservation;
    private int time;

    public int solution(int[] laser, String[] enter){
        init(enter);
        int answer = 0;

        while (true) {
            if (waiting.isEmpty()) {
                if (reservation.isEmpty()) {
                    break;
                } else {
                    time = reservation.peek()[0];
                    waiting.add(reservation.poll());
                }
            }
            int[] poll = waiting.poll();
            time += laser[poll[1]];

            while (!reservation.isEmpty()) {
                if (reservation.peek()[0] < time) {
                    waiting.add(reservation.poll());
                } else {
                    break;
                }
            }
            if (answer < waiting.size()) {
                answer = waiting.size();
            }
        }

        return answer;
    }

    private void init(String[] enter) {
        waiting = new LinkedList<>();
        reservation = new LinkedList<>();
        time = 0;

        for (String string : enter) {
            String[] s = string.split(" ");
            String time = s[0];
            String[] timeSplit = time.split(":");
            int convert = Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            int laserNum = Integer.parseInt(s[1]);
            reservation.add(new int[]{convert, laserNum});
        }
    }

    public static void main(String[] args){
        Problem4_1 T = new Problem4_1();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
