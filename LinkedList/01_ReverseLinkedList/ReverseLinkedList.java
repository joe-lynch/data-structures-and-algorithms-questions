import java.util.Arrays;

public class ReverseLinkedList {

    private ListNode reverseList(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }

        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        ListNode head = ListNode.createLinkedList(Arrays.asList(1,2,3,4,5));
        ListNode reversed = ListNode.createLinkedList(Arrays.asList(5,4,3,2,1));

        assert(solution.reverseList(head).equals(reversed));
    }
}
