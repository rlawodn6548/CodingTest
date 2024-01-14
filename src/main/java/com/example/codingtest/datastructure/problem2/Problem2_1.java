package com.example.codingtest.datastructure.problem2;

import java.util.Stack;

public class Problem2_1 {

    private Stack<String> stack;

    public String solution(String s){
        StringBuilder answer = new StringBuilder();

        init();

        for (int j = 0 ; j < s.length(); j++) {
            String c = s.substring(j, j+1);
            if (c.equals(")")) {
                StringBuilder temp = new StringBuilder();
                while (!stack.peek().equals("(")) {
                    temp.insert(0, stack.pop());
                }
                stack.pop();
                if (stack.peek().equals("(")) {
                    stack.push("1");
                }
                int times = Integer.parseInt(stack.pop());
                String content = temp.toString().repeat(times);
                stack.push(content);
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            String pop = stack.pop();
            answer.insert(0, pop);
        }

        return answer.toString();
    }

    private void init() {
        stack = new Stack<>();
    }

    public static void main(String[] args){
        Problem2_1 T = new Problem2_1();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
