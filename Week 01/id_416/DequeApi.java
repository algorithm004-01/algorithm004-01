package com.first.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeApi {
    public static void main(String[] args) {
        Deque<String> linkedList = new LinkedList<String>();
//        linkedList.addFirst("1");
//        linkedList.addFirst("2");
//
//        linkedList.addLast("3");
//        linkedList.addLast("4");

//        System.out.println(linkedList);
//        System.out.println(linkedList.peek());

//        linkedList.removeFirst();
//        System.out.println(linkedList);

//        linkedList.removeLast();
//        System.out.println(linkedList);
        linkedList.offerFirst("1");
        linkedList.offerFirst("2");

        linkedList.offerLast("3");
        linkedList.offerLast("4");
//        System.out.println(linkedList);
//        linkedList.pollFirst();
//        System.out.println(linkedList);

//        linkedList.pollLast();
//        System.out.println(linkedList);


//        linkedList.removeAll(linkedList);

//        System.out.println(linkedList.pollLast());
//        System.out.println(linkedList.remove());
        while (linkedList.size()>0){
            System.out.println(linkedList.removeLast());
        }
    }
}
