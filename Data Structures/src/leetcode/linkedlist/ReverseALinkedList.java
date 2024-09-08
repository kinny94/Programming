package leetcode.linkedlist;

public class ReverseALinkedList { }

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode previous = null;
        ListNode temp = null;

        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
        return head;
    }
}