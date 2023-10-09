package com.example.codingtest.simulation.problem6;

import java.util.ArrayList;
import java.util.List;

public class FruitExchange {

    public static void main(String[] args){
        FruitExchange T = new FruitExchange();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }

    public int solution(int[][] fruit){
        int answer = 0;
        List<Student> studentList = new ArrayList<>();

        init(fruit, studentList);

        for (int i=0; i<studentList.size() -1; i++) {
            if (studentList.get(i).isTrade()) {
                continue;
            }
            Student st1 = studentList.get(i);
            for (int j = i+1; j < studentList.size(); j++) {
                if (studentList.get(j).isTrade()) {
                    continue;
                }
                Student st2 = studentList.get(j);
                if (isTradable(st1,st2)) {
                    st1.setMinNumber(st1.getMinNumber() + 1);
                    st1.setTrade(true);
                    st2.setMinNumber(st2.getMinNumber() + 1);
                    st2.setTrade(true);
                    break;
                }
            }
        }

        for (int i=0; i<studentList.size(); i++) {
            answer += studentList.get(i).getMinNumber();
        }
        return answer;
    }

    private boolean isTradable(Student st1, Student st2) {
        if (st1.getMinNumberIndex() == st2.getMinNumberIndex()) {
            return false;
        }
        if (st1.getFruit()[st2.getMinNumberIndex()] <= 0 || st2.getFruit()[st1.getMinNumberIndex()] <= 0) {
            return false;
        }
        if (st1.getFruit()[st1.getMinNumberIndex()] +1 > st1.getFruit()[st2.getMinNumberIndex()] -1) {
            return false;
        }
        if (st2.getFruit()[st2.getMinNumberIndex()] +1 > st2.getFruit()[st1.getMinNumberIndex()] -1) {
            return false;
        }
        return true;
    }

    private void init(int[][] fruit, List<Student> studentList) {
        for (int i = 0; i < fruit.length; i++) {
            Student student = new Student(fruit[i]);
            studentList.add(student);
        }
    }

    class Student {
        private int[] fruit;
        private int minNumberIndex;
        private int minNumber = Integer.MAX_VALUE;
        private boolean trade;

        public Student(int[] fruit) {
            this.fruit = fruit;
            trade = false;
            for (int i = 0; i < fruit.length; i++) {
                if (minNumber > fruit[i]) {
                    minNumber = fruit[i];
                    minNumberIndex = i;
                }
            }
        }

        public boolean isTrade() {
            return trade;
        }

        public void setTrade(boolean trade) {
            this.trade = trade;
        }

        public int[] getFruit() {
            return fruit;
        }

        public void setFruit(int[] fruit) {
            this.fruit = fruit;
        }

        public int getMinNumberIndex() {
            return minNumberIndex;
        }

        public void setMinNumberIndex(int minNumberIndex) {
            this.minNumberIndex = minNumberIndex;
        }

        public int getMinNumber() {
            return minNumber;
        }

        public void setMinNumber(int minNumber) {
            this.minNumber = minNumber;
        }
    }
}
