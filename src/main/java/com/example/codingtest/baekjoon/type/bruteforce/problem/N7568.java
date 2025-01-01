package com.example.codingtest.baekjoon.type.bruteforce.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N7568 {
    public static void main(String[] args) {
        N7568 n7568 = new N7568();
        n7568.initializeData();
        n7568.calculateAndPrintScores();
    }

    private Pair[] pairs;
    private int[] scores;

    public void initializeData() {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            int numPerson = Integer.parseInt(bf.readLine());
            scores = new int[numPerson];
            pairs = new Pair[numPerson];

            for (int i=0; i<numPerson; i++) {
                StringTokenizer tk = new StringTokenizer(bf.readLine());

                int x = Integer.parseInt(tk.nextToken());
                int y = Integer.parseInt(tk.nextToken());
                Pair pair = new Pair(x, y);
                pairs[i] = pair;

                scores[i] = 1;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculateAndPrintScores() {
        for (int i=0; i<pairs.length-1; i++) {
            for (int j=i+1; j<pairs.length; j++) {
                int compare = compareScore(pairs[i], pairs[j]);
                if (compare > 0) {
                    scores[j]++;
                } else if (compare < 0) {
                    scores[i]++;
                }
            }
        }

        for (int score : scores) {
            System.out.print(score + " ");
        }
    }

    private int compareScore(Pair pair, Pair pair1) {
        if (pair.x > pair1.x && pair.y > pair1.y) {
            return 1;
        } else if (pair.x < pair1.x && pair.y < pair1.y) {
            return -1;
        }
        return 0;
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
