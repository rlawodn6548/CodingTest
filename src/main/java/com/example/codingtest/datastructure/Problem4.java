package com.example.codingtest.datastructure;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

public class Problem4 {
    public static void main(String[] args){
        Problem4 T = new Problem4();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }

    private Queue<Customer> customerTimeQueue;
    private Queue<Customer> waitQueue;
    private LocalTime cur;
    private int waiting;

    public int solution(int[] laser, String[] enter){
        init(enter);

        while(!customerTimeQueue.isEmpty()) {
            if (waitQueue.isEmpty()) {
                Customer customer = customerTimeQueue.poll();
                waitQueue.add(customer);
                cur = customer.getEnter();
            }
            Customer customer = waitQueue.poll();
            cur = cur.plusMinutes(laser[customer.getDuration()]);

            while (!customerTimeQueue.isEmpty()) {
                Customer peek = customerTimeQueue.peek();
                if (cur.isAfter(peek.getEnter())) {
                    waitQueue.add(customerTimeQueue.poll());
                } else {
                    break;
                }
            }
            if (waiting < waitQueue.size()) {
                waiting = waitQueue.size();
            }
        }

        return waiting;
    }

    private void init(String[] enters) {
        customerTimeQueue = new LinkedList<>();
        waitQueue = new LinkedList<>();
        waiting = 0;

        for (int i=0; i<enters.length; i++) {
            Customer customer = new Customer();
            String enter = enters[i];
            String[] data = enter.split(" ");
            customer.setDuration(Integer.parseInt(data[1]));
            String[] split = data[0].split(":");
            LocalTime enterTime = LocalTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            customer.setEnter(enterTime);
            customerTimeQueue.add(customer);
        }
    }

    @Getter
    @Setter
    class Customer {
        private LocalTime enter;
        private int duration;
    }
}
