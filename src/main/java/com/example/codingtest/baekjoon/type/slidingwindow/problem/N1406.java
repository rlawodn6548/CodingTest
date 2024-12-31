package com.example.codingtest.baekjoon.type.slidingwindow.problem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class N1406 {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String inputString = bf.readLine();
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();

            for (char c : inputString.toCharArray()) {
                left.push(c);
            }

            int numCommand = Integer.parseInt(bf.readLine());
            for (int i = 0; i < numCommand; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());

                switch (st.nextToken()) {
                    case "L":
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                        break;
                    case "D":
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                        break;
                    case "B":
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    case "P":
                        String s = st.nextToken();
                        left.push(s.charAt(0));
                        break;
                }
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            StringBuilder sb = new StringBuilder();
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
