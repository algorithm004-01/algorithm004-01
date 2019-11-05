import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * RewriteDeque
 */
public class RewriteDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");
        System.out.println(deque);

        String str1 = deque.getFirst();
        String str2 = deque.getLast();
        System.out.println(str2);
        System.out.println(str1);
        
        while (deque.size() > 0) {
            deque.removeFirst();
            System.out.println(deque);
        }
        System.out.println(deque);

        HashSet
        java.util.HashMap

        

        
        

        
    }
}

