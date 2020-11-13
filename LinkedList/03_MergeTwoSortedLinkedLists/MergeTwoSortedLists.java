import java.util.Arrays;

public class MergeTwoSortedLists {

    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode();
        ListNode ret = l3;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                l3.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else{
                l3.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        if(l1 != null) l3.next = l1;
        if(l2 != null) l3.next = l2;

        return ret.next;
    }


    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode lst = solution.mergeTwoLists(ListNode.createLinkedList(Arrays.asList(1,2,4)), ListNode.createLinkedList(Arrays.asList(1,3,4)));
        assert(lst.equals(ListNode.createLinkedList(Arrays.asList(1,1,2,3,4,4))));
    }
}
