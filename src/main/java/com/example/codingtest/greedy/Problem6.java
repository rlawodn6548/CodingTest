package com.example.codingtest.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem6 {
    public int solution(int n, int[][] trans, int[][] bookings){
        int answer=0;
        Map<Integer, Integer> pm = new HashMap<>();

        for(int[] tran : trans) {
            for (int i = tran[0]; i < tran[1]; i++) {
                pm.put(i, pm.getOrDefault(i,0) + tran[2]);
            }
        }
        Arrays.sort(bookings, (a,b) -> a[0] == b[0] ? a[1] - b[1]: a[0]-b[0]);

        for (int[] book : bookings) {
            if (checkUse(pm, book)) {
                for (int i = book[0] ; i < book[1] ; i++) {
                    pm.put(i, pm.get(i) -1);
                }
                answer++;
            }
        }


        return answer;
    }

    private boolean checkUse(Map<Integer, Integer> pm, int[] book) {
        for (int i = book[0] ; i < book[1] ; i++) {
            if (pm.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Problem6 T = new Problem6();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
