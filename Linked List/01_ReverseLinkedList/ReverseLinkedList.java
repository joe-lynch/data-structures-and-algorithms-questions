package LinkedList;

import java.util.Arrays;
import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object obj){
        ListNode o = (ListNode) obj;
         if(this == obj)
             return true;
         if(this.next == o.next){
             return true;
         }
         return this.val == o.val && this.next.equals(o.next);
    }

    public static ListNode createLinkedList(List<Integer> arr){
         if(arr.size() == 1){
             return new ListNode(arr.get(0));
         }
         return new ListNode(arr.get(0), createLinkedList(arr.subList(1, arr.size())));
    }
 }

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
