/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    if (head == null){
        return false;
    }
    Node x = head;
    Node y = head;

    while(x != null && x.next != null) {        
        x = x.next;
        y = y.next.next;
        
        if(y == null || x == null) {
            return false;
        }
        if(y == x){
            return true;
        }
    }
    return false;
}
