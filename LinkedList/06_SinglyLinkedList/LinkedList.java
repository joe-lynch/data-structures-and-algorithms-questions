
public class LinkedList {

    private ListNode head = null;
    private ListNode tail = null;
    private int n = 0; // list size
    
    
    public void addFirst(Object o) {
        if (n==0){
            head = new ListNode(o, head);
            tail = head;
        }
        else{
            head = new ListNode(o, head);
        }
        n++;
    }
    
    public void add(Object o) {
        if (n==0){
            addFirst(o);
            return;
        }
        else{
            //System.out.println(tail.element);
            tail.next = new ListNode(o, tail);
            tail = tail.next;
            
        }
        n++;
    }
    
    public Object get(int i) {
        if (i<0 || i>=n) ; // …error!
        ListNode node = head;
        for (int j=0; j<i; j++)
        node = node.next;
        return node.element;
    }
    
    public void insert(Object o, int i) {
        if (i<0 || i>n) ; // …error!
        
        if (i==0){
            addFirst(o);
            return;
        }

        if (i==n){
            add(o);
            return;
        }
        
        ListNode node = head;
        for (int j=0; j<i-1; j++)
        node = node.next;
        node.next = new ListNode(o, node.next);
        n++;
    }
    
    public void remove(int i) {
        if (i<0 || i>=n) ; // …error!
        
        if (i==0) { // special case
            head = head.next;
            n--;
            return;
        }
        
        if (i==n-1){
            ListNode previousToTail = head;
            while (previousToTail.next != tail){
                previousToTail = previousToTail.next;
            }
            tail = previousToTail;
            tail.next = null;
            n--;
            return;
        }
        
        ListNode node = head;
        for (int j=0; j<i-1; j++)
        node = node.next;
        node.next = node.next.next;
        n--;
    }
    
}
