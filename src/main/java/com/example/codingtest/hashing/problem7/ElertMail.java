package com.example.codingtest.hashing.problem7;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ElertMail {
    public static void main(String[] args){
        ElertMail T = new ElertMail();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }

    private Map<String, Employee> employeeMap;

    public String[] solution(String[] reports, int time){
        String[] answer = {};

        init();
        for (String report : reports) {
            String[] splits = report.split(" ");
            employeeMap.putIfAbsent(splits[0], new Employee(splits[0]));
            Employee employee = employeeMap.get(splits[0]);
            if (splits[2].equals("in")) {
                employee.setStart(LocalTime.parse(splits[1], DateTimeFormatter.ofPattern("HH:mm")));
            } else {
                employee.setEnd(LocalTime.parse(splits[1], DateTimeFormatter.ofPattern("HH:mm")));
                Duration between = Duration.between(employee.getStart(), employee.getEnd());
                employee.setTotalTime(employee.getTotalTime() + between.toMinutes());
            }
        }

        List<String> answerList = new ArrayList<>();
        for (String name : employeeMap.keySet()) {
            Employee employee = employeeMap.get(name);
            if (employee.getTotalTime() > time) {
                answerList.add(employee.getName());
            }
        }

        Collections.sort(answerList, (a,b) -> {
            return a.compareTo(b);
        });

        answer = new String[answerList.size()];
        for (int i=0; i<answerList.size() ; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private void init() {
        employeeMap = new HashMap<>();
    }

    class Employee {
        private String name;
        private long totalTime;
        private LocalTime start;
        private LocalTime end;

        public Employee(String name) {
            this.name = name;
            totalTime = 0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getTotalTime() {
            return totalTime;
        }

        public void setTotalTime(long totalTime) {
            this.totalTime = totalTime;
        }

        public LocalTime getStart() {
            return start;
        }

        public void setStart(LocalTime start) {
            this.start = start;
        }

        public LocalTime getEnd() {
            return end;
        }

        public void setEnd(LocalTime end) {
            this.end = end;
        }
    }
}
