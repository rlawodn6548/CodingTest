package com.example.codingtest.datastructure.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UnzipBracket {
    public static void main(String[] args){
        UnzipBracket T = new UnzipBracket();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }

    private Stack<Character> stack;

    public String solution(String s){
        String answer = "";

        init();
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] ==')') {
                List<Character> charList = new ArrayList<>();
                Character pop;

                while (true) {
                    pop = stack.pop();
                    if (pop == '(') {
                        break;
                    }
                    charList.add(pop);
                }
                pop = stack.pop();
                int times;

                if (pop == '(') {
                    stack.push(pop);
                    times = 1;
                } else {
                    times = (int) pop - 48;
                }

                for (int j=0; j<times; j++) {
                    for (int index = charList.size()-1; index >=0; index--) {
                        stack.push(charList.get(index));
                    }
                }
            } else {
                stack.push(chars[i]);
            }
        }

        char[] answerChar = new char[stack.size()];
        for (int i=stack.size()-1; i>=0; i--) {
            answerChar[i] = stack.pop();
        }
        answer = new String(answerChar);
        return answer;
    }

    private void init() {
        stack = new Stack<>();
    }


}
