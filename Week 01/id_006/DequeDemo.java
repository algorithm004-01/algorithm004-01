package com.mrglint.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author luhuancheng
 * @since 2019-10-20 10:34
 */
public class DequeDemo {
    public static void main(String[] args) {
        // 一个使用链表实现的无界双端队列
        Deque<String> deque = new LinkedList<>();

        // 从头部入队
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        // 从尾部入队
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            // 从头部出队
            System.out.println(deque.removeFirst());
        }

        System.out.println(deque);
    }
}

