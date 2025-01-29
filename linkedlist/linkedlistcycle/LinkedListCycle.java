package linkedlist.linkedlistcycle;

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}

public class LinkedListCycle {

    // time complexity : O(n), in worst case where no cycle present would traverse through till last node of linked list.
    // space complexity : O(1), no extra space is used.
    public boolean hasCycle1(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        
        return false;
    }


    // time complexity : O(n), loop processes each node exactly once, map's method used O(1) on average.
    // space complexity : O(n), Hashmap data structure is used depends upon nodes of linked list.
    public boolean hasCycle2(ListNode head) {
        
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode tempNode = head;

        while(tempNode != null) {
            if (map.containsKey(tempNode)) {
                return true;
            }
            map.put(tempNode, 1);

            tempNode = tempNode.next;
        }
        
        return false;
    }
    
}
