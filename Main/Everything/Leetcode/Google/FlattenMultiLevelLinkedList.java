class FlattenMultiLevelLinkedList {
    public Node flatten(Node head) {
        if (head == null) return head;
        
        Node p = head;
        
        while(p != null) {
            // if no child
            if (p.child == null) {
                p = p.next;
                continue;
            }
            
            //got child, find the tail of the child and link it p.next
            Node temp = p.child;
            while(temp.next != null) {
                temp = temp.next;
            }
            
            temp.next = p.next;
            
            // connect tail with p.next, if its not null
            if (p.next != null ){
                p.next.prev = temp;
            }
            
            // connect p with p.child and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}