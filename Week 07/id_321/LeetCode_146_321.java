package week07;

import java.util.HashMap;

public class LRUCache146 {

	class LRUCache {
		// key -> Node(key, val)
		private HashMap<Integer, Node> map;
		// Node(k1, v1) <-> Node(k2, v2)...
		private DoubleList cache;
		// �������
		private int cap;

		public LRUCache(int capacity) {
			this.cap = capacity;
			map = new HashMap<>();
			cache = new DoubleList();
		}

		public int get(int key) {
			if (!map.containsKey(key))
				return -1;
			int val = map.get(key).val;
			// ���� put �����Ѹ�������ǰ
			put(key, val);
			return val;
		}

		public void put(int key, int val) {
			// �Ȱ��½ڵ� x ������
			Node x = new Node(key, val);

			if (map.containsKey(key)) {
				// ɾ���ɵĽڵ㣬�µĲ嵽ͷ��
				cache.remove(map.get(key));
				cache.addFirst(x);
				// ���� map �ж�Ӧ������
				map.put(key, x);
			} else {
				if (cap == cache.size()) {
					// ɾ���������һ������
					Node last = cache.removeLast();
					map.remove(last.key);
				}
				// ֱ����ӵ�ͷ��
				cache.addFirst(x);
				map.put(key, x);
			}
		}
	}

}

class Node {
	public int key, val;
	public Node next, prev;

	public Node(int k, int v) {
		this.key = k;
		this.val = v;
	}
}

class DoubleList {
	private Node head, tail; // ͷβ��ڵ�
	private int size; // ����Ԫ����

	public DoubleList() {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	// ������ͷ����ӽڵ� x
	public void addFirst(Node x) {
		x.next = head.next;
		x.prev = head;
		head.next.prev = x;
		head.next = x;
		size++;
	}

	// ɾ�������е� x �ڵ㣨x һ�����ڣ�
	public void remove(Node x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
		size--;
	}

	// ɾ�����������һ���ڵ㣬�����ظýڵ�
	public Node removeLast() {
		if (tail.prev == head)
			return null;
		Node last = tail.prev;
		remove(last);
		return last;
	}

	// ����������
	public int size() {
		return size;
	}
}
