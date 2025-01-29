package com.example.codingtest.hashing.problem6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6_2 {
    private List<Report> reportList;
    private int startTime;
    private int endTime;
    private List<Report> answerList;

    public String[] solution(String[] reports, String times){
        String[] answer = {};
        init(reports, times);

        Collections.sort(reportList, (a,b) -> {
            if (a.time <= b.time) {
                return -1;
            } else {
                return 1;
            }
        });

        for (Report report : reportList) {
            if (report.time >= startTime && report.time <= endTime) {
                answerList.add(report);
            }
        }
        answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i).name;
        }
        return answer;
    }

    private void init(String[] reports, String times) {
        reportList = new ArrayList<>();
        answerList = new ArrayList<>();

        String[] splited = times.split(" ");
        startTime = convertTimeToInt(splited[0]);
        endTime = convertTimeToInt(splited[1]);

        for (String report : reports) {
            Report rep = new Report();
            String[] elem = report.split(" ");
            rep.name = elem[0];
            rep.time = convertTimeToInt(elem[1]);
            reportList.add(rep);
        }
    }

    private int convertTimeToInt(String time) {
        int response = 0;
        String[] timeSplit = time.split(":");
        response = Integer.parseInt(timeSplit[0]) * 60;
        response += Integer.parseInt(timeSplit[1]);
        return response;
    }

    class Report {
        String name;
        int time;
    }

    public static void main(String[] args){
        Problem6_2 T = new Problem6_2();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
