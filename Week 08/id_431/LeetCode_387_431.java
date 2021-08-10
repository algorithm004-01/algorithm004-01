package easy;

import javax.naming.Name;
import java.awt.dnd.DnDConstants;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘磊明
 * @date 2019/12/11
 */
public class FirstUniqueCharacterInAString {
//    public int firstUniqChar(String s) {
//        char[] array = s.toCharArray();
//        char c = '@';
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            if (map.containsKey(array[i])) {
//                array[map.get(array[i])] = c;
//                array[i] = c;
//            } else {
//                map.put(array[i], i);
//            }
//        }
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != c) return i;
//        }
//        return -1;
//    }

    DNode head = new DNode();
    DNode tail = new DNode();

    public int firstUniqChar(String s) {
        char[] array = s.toCharArray();
        head.next = tail;
        tail.prev = head;
        Map<Character, DNode> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                DNode node = map.get(array[i]);
                node.count += 1;
                moveNodeToEnd(node);
            } else {
                DNode node = new DNode();
                node.i = i;
                node.count = 1;
                addNode(node);
                map.put(array[i], node);
            }
        }
        DNode d = head.next;
        if (d.count == 1) return d.i;
        else return -1;
    }

    private void addNode(DNode node){
        DNode tmp = tail.prev;
        tmp.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = tmp;
    }

    private void moveNodeToEnd(DNode node){
        if (node.prev == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    class DNode {
        private int i;
        private int count;
        DNode prev;
        DNode next;
    }
}
