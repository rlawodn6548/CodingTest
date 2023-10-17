package com.example.codingtest.hashing.problem5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Votes {

    public static void main(String[] args){
        Votes T = new Votes();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }

    private Map<String, List<String>> choiced;
    private Map<String, Integer> gifts;

    public String solution(String[] votes, int k){
        String answer = null;

        init();
        for (String vote : votes) {
            String[] split = vote.split(" ");


            if (choiced.containsKey(split[1])) {
                List<String> selector = choiced.get(split[1]);
                selector.add(split[0]);
            } else {
                ArrayList<String> selector = new ArrayList<>();
                selector.add(split[0]);
                choiced.put(split[1], selector);
            }
        }

        for(String candidate : choiced.keySet()) {
            if (choiced.get(candidate).size() >= k) {
                List<String> selectors = choiced.get(candidate);
                for (String selector : selectors) {
                    gifts.put(selector, gifts.getOrDefault(selector, 0) + 1 );
                }
            }
        }


        int max = 0;
        for (String selector : gifts.keySet()) {
            if (gifts.get(selector) >= max) {
                if (gifts.get(selector) > max) {
                    answer = selector;
                    max = gifts.get(selector);
                } else if (selector.compareTo(answer) < 0) {
                    answer = selector;
                }
            }
        }

        return answer;
    }

    private void init() {
        choiced = new HashMap<>();
        gifts = new HashMap<>();
    }
}
