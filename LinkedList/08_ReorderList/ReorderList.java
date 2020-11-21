import java.util.Arrays;

public class ReorderList {

    public void reorderList(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        // find middle of linked list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half of linked list
        ListNode snd = slow;
        ListNode tmp;
        ListNode prev = null;
        while(snd != null){
            tmp = snd.next;
            snd.next = prev;
            prev = snd;
            snd = tmp;
        }

        // merge
        ListNode first = head, second = prev;
        while(second.next != null){
            tmp = first.next;
            first.next = prev;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();
        ListNode head = ListNode.createLinkedList(Arrays.asList(1,2,3,4));
        solution.reorderList(head);

        assert(head.equals(ListNode.createLinkedList(Arrays.asList(1,4,2,3))));
    }
}
