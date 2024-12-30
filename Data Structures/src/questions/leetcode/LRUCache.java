package questions.leetcode;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            ListNode oldNode = map.get(key);
            remove(oldNode);
        }

        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        add(newNode);

        if (map.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
    }

    public void add(ListNode node) {
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;
        node.prev = prevEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


