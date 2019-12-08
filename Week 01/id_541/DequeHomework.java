package leetcode.editor.cn;

import javax.swing.plaf.synth.SynthStyle;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class DequeHomework {

    public static void main(String[] args) {

        //学习源码的一些基础语法
//        int a = 0,b = 0,c = 0;
//        a = b  = 1;
//        int[] aa = new int[]{1,2,3};
//        int[] bb = new int[]{4,5,6};
//        System.arraycopy(aa,0,bb,0,3);
//        if ( a == 1 || b == 0 && c == 1){
//            System.out.println(1);
//        }
//        System.out.println(a);
//        System.out.println(b);
//        mainQueue(args);
        mainDeque(args);
    }

    public static void mainQueue(String[] args) {

        Deque<String> deque = new ArrayDeque<String>();
        //deque的queue用法
        deque.offer("1"); //offer继承于queue,先进先出。
//            deque.addFirst("1");    //offer的新api
//            deque.offerFirst("1");
        deque.offer("2");
        deque.offer("3");
        deque.offer("4");
        deque.addFirst("0");
        System.out.println(deque); //[1, 2, 3, 4]
        deque.pollFirst();
        System.out.println(deque); //[1, 2, 3, 4]

        String polledElement = deque.poll(); // == 1 ,符合queue的先进先出
        System.out.println(polledElement);
        System.out.println(deque);   //[2, 3, 4]

        String peekElement = deque.peek(); // == 2 (只看不拿) ，
        System.out.println(peekElement);
        System.out.println(deque);   //[2, 3, 4]

        while (deque.size()>0){
            System.out.println(deque.poll()); //先进先出 2，3，4
        }
    }

    public static void mainDeque(String[] args) {

//        Queue queue = newew

        Deque<String> deque = new LinkedList();
        Deque<String> deque1 = new ArrayDeque<String>();
        //deque的用法
        deque.addLast("1"); // queue的offer = deque的addLast
        deque.addLast("2");
        deque.addLast("3");
        deque.addLast("4");
        deque1.isEmpty();
        System.out.println(deque); //[1, 2, 3, 4]
        System.out.println(deque.getFirst());

        String polledElement = deque.pollFirst(); //
        System.out.println(polledElement);
        System.out.println(deque);   //[2, 3, 4]

        String peekElement = deque.peekFirst(); //
        System.out.println(peekElement);
        System.out.println(deque);   //[2, 3, 4]

        while (deque.size()>0){
            System.out.println(deque.pollFirst()); //先进先出 2，3，4
        }
    }


    private static void printElemrnt(Deque<String> deque) {
        for (String s: deque){
            System.out.println(s);
        }
    }
}
