package com.example.codingtest.greedy;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem5 {
    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];
        Map<String, Integer> tm = new HashMap<>();
        ArrayList<Student> list = new ArrayList<>();

        for (int i = 0; i < students.length; i++) {
            String[] split = students[i].split(" ");
            list.add(new Student(i, Integer.parseInt(split[1]), split[0]));
        }

        list.sort((a,b) -> a.score - b.score);

        int sum = 0;
        for (int i = 0, j=0; i<list.size(); i++) {
            int sameValue = 0;
            for (; j<i; j++) {
                if (list.get(i).score == list.get(j).score) {
                    sameValue += list.get(j).score;
                }
            }
            answer[list.get(i).index] = sum - tm.getOrDefault(list.get(i).team, 0) - sameValue;
            sum += list.get(i).score;
            tm.put(list.get(i).team, list.get(i).score + tm.getOrDefault(list.get(i).team,0));
        }

        return answer;
    }

    public static void main(String[] args){
        Problem5 T = new Problem5();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }

    @AllArgsConstructor
    class Student {
        int index;
        int score;
        String team;
    }
}
