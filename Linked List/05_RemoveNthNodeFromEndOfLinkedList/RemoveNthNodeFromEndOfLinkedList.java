package LinkedList;

import java.util.Arrays;

public class RemoveNthNodeFromEndOfLinkedList {

    private ListNode removeNthNodeFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for(int i=1; i<= n + 1; i++){
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfLinkedList solution = new RemoveNthNodeFromEndOfLinkedList();
        ListNode lst = solution.removeNthNodeFromEnd(ListNode.createLinkedList(Arrays.asList(1,2,3,4,5)), 2);

        assert(lst.equals(ListNode.createLinkedList(Arrays.asList(1,2,3,5))));
    }
}
