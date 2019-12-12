
import java.util.Deque;
import java.util.LinkedList;

public class deque {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<String>();
		deque.add("b");
		deque.addFirst("a");
		deque.addLast("c");
		System.out.println(deque);
		
		String str = deque.element();
		System.out.println(str);
		System.out.println(deque);
		
		while (deque.size()>0) {
			System.out.println(deque.removeFirst());
		}
		System.out.println(deque);
	}
}
