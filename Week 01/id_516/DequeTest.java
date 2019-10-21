package com.hjj.test;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {
        oldAPI();
        newAPI();
    }

    public static void oldAPI() {
        Deque<String>  deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String peek = deque.peek();
        System.out.println(peek);
        System.out.println(deque);


        while (deque.size() > 0 ) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }


    public static void newAPI() {
        Deque<String>  deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String peek = deque.getFirst();
        System.out.println(peek);
        String peekFirst = deque.peekFirst();
        System.out.println(peekFirst);

        String last = deque.getLast();
        System.out.println(last);

        String peekLast = deque.peekLast();
        System.out.println(peekLast);
        System.out.println(deque);


        while (deque.size() > 0 ) {
            System.out.println(deque.pollFirst());
        }
        // 可能为空
        System.out.println(deque.pollFirst());
        try {
            // 报错
            System.out.println(deque.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(deque);


        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");

        System.out.println(deque);

        System.out.println(deque.element() == deque.getFirst());
    }
}
