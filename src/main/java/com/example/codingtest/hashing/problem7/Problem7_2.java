package com.example.codingtest.hashing.problem7;

import java.util.*;

public class Problem7_2 {

    private Map<String, Integer> totalCntMap;
    private Map<String, Report> room;

    public String[] solution(String[] reports, int time){
        List<String> answerList = new ArrayList<>();
        String[] answer = {};
        init();

        for (String report : reports) {
            String[] splited = report.split(" ");
            if (splited[2].equals("in")) {
                Report re = new Report();
                re.name = splited[0];
                re.in = convertToTime(splited[1]);
                room.put(splited[0], re);
            } else {
                Report re = room.get(splited[0]);
                int duration = convertToTime(splited[1]) - re.in;

                totalCntMap.put(re.name, duration + totalCntMap.getOrDefault(re.name, 0));
            }
        }

        for (String name : totalCntMap.keySet()) {
            Integer duration = totalCntMap.get(name);
            if (duration > time) {
                answerList.add(name);
            }
        }
        answerList.sort((o1, o2) -> {
            if (o1.compareTo(o2) <= 0) {
                return -1;
            } else {
                return 1;
            }
        });
        answer = new String[answerList.size()];
        answerList.toArray(answer);
        return answer;
    }

    private int convertToTime(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0])* 60 + Integer.parseInt(times[1]);
    }

    private void init() {
        totalCntMap = new HashMap<>();
        room = new HashMap<>();
    }

    class Report {
        String name;
        int in;
    }

    public static void main(String[] args){
        Problem7_2 T = new Problem7_2();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
