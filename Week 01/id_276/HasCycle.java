package linkedlist;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while(runner!=null && runner.next!=null) {
            walker = walker.next;
            //runner = runner.next.next; //when runner.next == null this should  break out
            runner = runner.next;
            if (runner == null)
                break;
            runner = runner.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
