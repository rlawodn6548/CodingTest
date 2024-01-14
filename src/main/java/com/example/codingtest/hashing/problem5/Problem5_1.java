package com.example.codingtest.hashing.problem5;

import java.util.*;

public class Problem5_1 {

    private Map<String, List<String>> candidators;
    private Map<String, Integer> voteCount;
    private PriorityQueue<String> answerQueue;

    public String solution(String[] votes, int k){
        String answer = " ";

        init();

        for (String vote : votes) {
            String[] s = vote.split(" ");

            if (!candidators.containsKey(s[1])) {
                candidators.put(s[1], new ArrayList<>());
            }
            List<String> voters = candidators.get(s[1]);
            voters.add(s[0]);
        }
        int max = 0;
        for (String candidator : candidators.keySet()) {
            List<String> voters = candidators.get(candidator);
            if (voters.size() < k) {
                continue;
            }
            for (String voter : voters) {
                int cnt = voteCount.getOrDefault(voter, 0) + 1;
                voteCount.put(voter, cnt);
                max = Math.max(max, cnt);
            }
        }

        for (String voter : voteCount.keySet()) {
            Integer cnt = voteCount.get(voter);
            if (cnt == max) {
                answerQueue.add(voter);
            }
        }

        answer = answerQueue.poll();
        return answer;
    }

    private void init() {
        candidators = new HashMap<>();
        voteCount = new HashMap<>();
        answerQueue = new PriorityQueue<>();
    }

    public static void main(String[] args){
        Problem5_1 T = new Problem5_1();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
