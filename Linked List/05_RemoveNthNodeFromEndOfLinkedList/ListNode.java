package LinkedList;

import java.util.List;

public class ListNode {
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