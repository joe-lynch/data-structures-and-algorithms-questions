class DoublyLinkedList {
    private ListNode2 head = null;
    private int n = 0; // list size

    public void addFirst(Object o) {
        ListNode2 temp = new ListNode2(o, null, head);
        if(head != null ) {
            head.prev = temp;
        }
        head = temp;
        n++;
    }
 
    public Object get(int i) {
        if (i<0 || i>=n){
            System.err.println("Error");
        }
        
        ListNode2 node = head;
        for (int j=0; j<i; j++){
            node = node.next;
        }
        return node.element;
    }
    
    
    public void insert(Object o, int i) {
        if (i<0 || i>n){
            System.err.println("Error");
            return;
        }
        
        if (i==0){
            addFirst(o);
            return;
        }
        
        ListNode2 node = head;
        
        for (int j=0; j<i-1; j++){
            node = node.next;
        }
        
        ListNode2 temp = new ListNode2(o, node, node.next);
        
        if(node.next != null){
            node.next.prev = temp;
        }
        
        node.next = temp;
        
        n++;
    }
    
    
    public void remove(int i) {
        if (i<0 || i>=n){
            System.err.println("Error");
            return;
        }
        
        ListNode2 node = head;
        
        if (i==0) { // special case
            head = node.next;
            
            if(head!=null){
                head.prev = null;
            }
            
            n--;
            return;
        }
        
        for (int j=0; j<i; j++){
            node = node.next;
        }
        
        node.prev.next = node.next;
        
        if(node.next != null){
            node.next.prev = node.prev;
        }
        
        n--;
    }

    /**
     * Prints out the elements in the list from the first to the last (front to back) and then from the last to the first
     * (back to front). This is useful to test whether the list nodes are connected correctly with next and prev references.
     */
    public void print() {
        // no elements to print for empty list
        if (head == null) {
            System.out.println("list empty.");
            return;
        }

        // follow next references to list elements from the front to the back of the list
        System.out.print("front to back: ");
        ListNode2 node = head;
        System.out.print(node.element + " ");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.element + " ");
        }

        // follow prev references to list elements from the back to the front of the list
        System.out.print("-- and back to front: ");
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.prev;      
            //System.out.print(node.element + " ");
        }
        System.out.println();
    }
}
