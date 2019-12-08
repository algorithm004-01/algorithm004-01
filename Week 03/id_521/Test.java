import java.util.LinkedList;
import java.util.Queue;


public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Boolean b = queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(b);
        System.out.println(queue);
        Integer i = queue.poll();
        System.out.println(i);
        // i = queue.poll();
        System.out.println(i);
        System.out.println(queue.size());
    }
}