class SwapAdjacentNode {
    public ListNode swapPairs(ListNode head) {
        if((head == null) || (head.next == null) ) 
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        System.out.println(n.val + " ==> " + n.next.val);
        return n;
    }
}