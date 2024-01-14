package com.example.codingtest.hashing.problem7;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Problem7_1 {

    private Map<String, Infomant> infomantMap;
    private List<String> warningMailList;

    public String[] solution(String[] reports, int time){
        String[] answer = {};

        init();

        for (String report : reports) {
            String[] s = report.split(" ");
            if (!infomantMap.containsKey(s[0])) {
                Infomant infomant = new Infomant();
                infomant.name = s[0];
                infomantMap.put(s[0], infomant);
            }
            Infomant infomant = infomantMap.get(s[0]);
            if (s[2].equals("in")) {
                infomant.in = LocalTime.parse(s[1], DateTimeFormatter.ofPattern("HH:mm"));
            } else {
                infomant.out = LocalTime.parse(s[1], DateTimeFormatter.ofPattern("HH:mm"));
                int duration = infomant.getTime();
                if (duration > time) {
                    warningMailList.add(infomant.name);
                }
            }
        }
        warningMailList.sort(String::compareTo);

        answer = new String[warningMailList.size()];
        warningMailList.toArray(answer);
        return answer;
    }

    private void init() {
        infomantMap = new HashMap<>();
        warningMailList = new ArrayList<>();
    }

    class Infomant {
        String name;
        LocalTime in;
        LocalTime out;
        int totalTime = 0;

        public int getTime() {
            totalTime += (int)Duration.between(in, out).toMinutes();
            return totalTime;
        }
    }

    public static void main(String[] args){
        Problem7_1 T = new Problem7_1();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
