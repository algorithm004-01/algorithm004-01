package com.first.stack;

import java.util.Stack;

public class StackApi {
    public static void main(String[] args) {
        Stack s  = new Stack();
        s.push("1231");
        s.push("1234");
        s.push("1235");
        s.push("123");
//        System.out.println(s.search("1231"));
//        s.pop();
        System.out.println(s.peek());
    }

}
