package com.example.codingtest.hashing.problem6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CompareTime {
    public static void main(String[] args){
        CompareTime T = new CompareTime();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }

    private LocalTime startTime;
    private LocalTime endTime;
    private List<Member> members;

    public String[] solution(String[] reports, String times){
        String[] answer;

        init(times);

        for (String report : reports) {
            String[] splits = report.split(" ");
            Member member = new Member(splits[0], splits[1]);
            members.add(member);
        }
        Collections.sort(members);
        List<Member> answerList = new ArrayList<>();
        for (Member elem : members) {
            if (startTime.compareTo(elem.getTime()) <=0 && endTime.compareTo(elem.getTime()) >=0) {
                answerList.add(elem);
            }
        }
        answer = new String[answerList.size()];
        for (int i=0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i).getName();
        }
        return answer;
    }

    private void init(String times) {
        String[] time = times.split(" ");
        startTime = LocalTime.parse(time[0], DateTimeFormatter.ofPattern("HH:mm"));
        endTime = LocalTime.parse(time[1], DateTimeFormatter.ofPattern("HH:mm"));
        members = new ArrayList<>();
    }

    class Member implements Comparable<Member> {
        String name;
        LocalTime time;

        public Member(String name, String localTime) {
            this.name = name;
            time = LocalTime.parse(localTime, DateTimeFormatter.ofPattern("HH:mm"));
        }

        public String getName() {
            return name;
        }

        public LocalTime getTime() {
            return time;
        }

        @Override
        public int compareTo(Member o) {
            if (time.isBefore(o.getTime())) {
                return -1;
            }
            return 1;
        }
    }
}
