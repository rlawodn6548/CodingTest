package com.example.codingtest.yanolza.codingtest;

import java.util.*;

public class Problem3 {
    public String solution(String[] lottos) {
        String answer = "";
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> bonusMap = new HashMap<>();

        for (String lotto : lottos) {
            String[] split = lotto.split(" ");
            for (String elem : split) {
                if (elem.startsWith("(")) {
                    String substring = elem.substring(1, elem.length() - 1);
                    int key = Integer.parseInt(substring);
                    bonusMap.put(key, bonusMap.getOrDefault(key, 0) + 1);
                } else {
                    int key = Integer.parseInt(elem);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
        }

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return -1;
                }
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return 1;
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        PriorityQueue<int[]> bonusPq = new PriorityQueue<>(comparator);

        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            pq.add(new int[]{key, value});
        }
        for (Integer key : bonusMap.keySet()) {
            Integer value = bonusMap.get(key);
            bonusPq.add(new int[]{key, value});
        }

        List<LNumber> list = new ArrayList<>();
        for (int i=0; i<6; i++) {
            int[] poll = pq.poll();
            LNumber lNumber = new LNumber();
            lNumber.value = poll[0];
            lNumber.exp = ""+poll[0];
            list.add(lNumber);
        }
        while(true) {
            boolean flag = false;
            int[] poll = bonusPq.poll();
            for (LNumber number : list) {
                if (number.value == poll[0]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            LNumber lNumber = new LNumber();
            lNumber.value = poll[0];
            lNumber.exp = "("+ poll[0] + ")";
            list.add(lNumber);
            break;
        }
        list.sort((a,b) -> a.value - b.value);

        for (LNumber n : list) {
            answer += n.exp + " ";
        }

        return answer.substring(0, answer.length());
    }

    class LNumber{
        int value;
        String exp;
    }
    public static void main(String[] args){
        Problem3 T = new Problem3();
//        System.out.println(T.solution(new String[]{"10 18 23 33 (15) 29 45", "42 (5) 45 32 15 23 12", "19 6 12 16 35 34 (17)", "(15) 23 26 21 20 37 12", "15 20 39 9 (18) 5 12", "18 (20) 11 5 22 21 25", "42 44 23 8 5 22 (20)"}));
        System.out.println(T.solution(new String[]{"15 10 39 5 1 21 (22)", "11 5 (10) 39 1 8 44", "(39) 10 5 22 15 9 20", "22 10 5 1 (15) 3 2", "10 (5) 22 1 15 41 38", "10 5 39 33 17 14 (1)"}));
    }
}
