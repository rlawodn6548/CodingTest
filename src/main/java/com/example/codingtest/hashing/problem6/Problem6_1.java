package com.example.codingtest.hashing.problem6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem6_1 {
    private List<Report> reportList;
    private LocalTime start;
    private LocalTime end;
    private List<Report> answerList;

    public String[] solution(String[] reports, String times){
        String[] answer = {};

        init(reports, times);

        for (Report report : reportList) {
            if (!report.time.isBefore(start) && !report.time.isAfter(end)) {
                answerList.add(report);
            }
        }
        answerList.sort((a, b) -> {
            return a.time.isBefore(b.time)? -1 : 1;
        });
        answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i).name;
        }

        return answer;
    }

    private void init(String[] reports, String times) {
        String[] split = times.split(" ");
        start = LocalTime.parse(split[0], DateTimeFormatter.ofPattern("HH:mm"));
        end = LocalTime.parse(split[1], DateTimeFormatter.ofPattern("HH:mm"));
        answerList = new ArrayList<>();
        reportList = new ArrayList<>();
        for (String report : reports) {
            String[] elem = report.split(" ");
            Report reportObject = new Report();
            reportObject.name = elem[0];
            reportObject.time = LocalTime.parse(elem[1], DateTimeFormatter.ofPattern("HH:mm"));
            reportList.add(reportObject);
        }
    }

    public static void main(String[] args){
        Problem6_1 T = new Problem6_1();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }

    class Report {
        String name;
        LocalTime time;
    }
}
