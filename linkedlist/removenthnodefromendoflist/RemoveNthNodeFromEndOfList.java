package linkedlist.removenthnodefromendoflist;


class ListNode {
    int val;
    ListNode next;

    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNthNodeFromEndOfList {

    // Approach 1 - single pass
    // time complexity : O(L), since algo pass through list once i.e length of the list.
    // space complexity : O(1), constant amount of extra space is used.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if(fast == null) return head.next;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode deletedNode = slow.next;
        slow.next = deletedNode.next;

        return head;
        
    }
}
