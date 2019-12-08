class LRUCache {

    class DoubleLinkedListNode {
        public int key;
        public int value;
        public DoubleLinkedListNode prev;
        public DoubleLinkedListNode next;
    }

    private Map<Integer, DoubleLinkedListNode> memo;
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    private int size;
    private int capacity;

    private void add(DoubleLinkedListNode newNode) {
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    private DoubleLinkedListNode pop() {
        if (head.next == tail) {
            return null;
        }
        size--;
        DoubleLinkedListNode first = head.next;
        head.next = first.next;
        head.next.prev = head;
        return first;
    }

    private void moveToTail(DoubleLinkedListNode node) {
        if (this.size == 1) {
            return;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.memo = new HashMap<>(capacity);
        this.size = 0;
        this.head = new DoubleLinkedListNode();
        this.tail = new DoubleLinkedListNode(); 
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if(memo.containsKey(key)) {
            DoubleLinkedListNode temp = memo.get(key);
            this.moveToTail(temp);
            return temp.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DoubleLinkedListNode temp = null;
        if(memo.containsKey(key)) { 
            temp = memo.get(key);
            temp.value = value;
            this.moveToTail(temp);
        } else {
            temp = new DoubleLinkedListNode();
            temp.key = key;
            temp.value = value;
            if(this.size == this.capacity) {
                DoubleLinkedListNode deleted = this.pop();
                this.memo.remove(deleted.key);
            }
            this.add(temp);
            this.memo.put(key, temp);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
