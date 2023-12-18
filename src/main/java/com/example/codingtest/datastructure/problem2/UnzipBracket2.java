package com.example.codingtest.datastructure.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UnzipBracket2 {
    public static void main(String[] args){
        UnzipBracket2 T = new UnzipBracket2();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }

    private Stack<String> stack;

    public String solution(String s){
        String answer = "";

        init();
        for (Character c : s.toCharArray()) {
            if (c == ')') {
                String tmp = "";
                while(!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (pop.equals("(")) {
                        Integer num;
                        if (Character.isDigit(stack.peek().charAt(0))) {
                            num = Integer.parseInt(stack.pop());
                        } else {
                            num = 1;
                        }
                        for (int i=0; i<num; i++) {
                            stack.push(tmp);
                        }
                        break;
                    } else {
                        tmp = pop + tmp;
                    }
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }

        while(!stack.isEmpty()) {
            String str = stack.pop();
            answer = str + answer;
        }
        return answer;
    }

    private void init() {
        stack = new Stack<>();
    }


}
