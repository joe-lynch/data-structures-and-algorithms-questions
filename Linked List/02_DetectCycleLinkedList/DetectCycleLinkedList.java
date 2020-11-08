package LinkedList;

import java.util.Arrays;

public class DetectCycleLinkedList {

    private boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleLinkedList solution = new DetectCycleLinkedList();
        // form a linked list with a cycle where end node points to tmp node
        ListNode end = new ListNode(-4);
        ListNode tmp = new ListNode(3, new ListNode(0, end));
        end.next = tmp;
        ListNode lst = new ListNode(2, tmp);

        assert(solution.hasCycle(lst));
        assert(solution.hasCycle(ListNode.createLinkedList(Arrays.asList(1,2,3,4))));
    }


}
