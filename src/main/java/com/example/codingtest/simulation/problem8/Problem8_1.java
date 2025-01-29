package com.example.codingtest.simulation.problem8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem8_1 {
    private List<Integer> room;
    private int[] cnt;

    public int[] solution(int[] enter, int[] exit){
        int[] answer = {};
        int inidx = 0;
        int outidx = 0;
        int n = enter.length;
        init(enter);

        while (inidx < n || outidx < n) {
            while (outidx < n && room.contains(exit[outidx])) {
                int index = room.indexOf(exit[outidx]);
                room.remove(index);
                outidx++;
            }

            if (inidx <n) {
                int ent = enter[inidx++];

                if (!room.isEmpty()) {
                    cnt[ent-1] += room.size();
                    for (int elem : room) {
                        cnt[elem-1]++;
                    }
                }
                room.add(ent);
            }
        }

        answer = cnt;
        return answer;
    }

    private void init(int[] enter) {
        room = new ArrayList<>();
        cnt = new int[enter.length];
    }

    public static void main(String[] args){
        Problem8_1 T = new Problem8_1();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
