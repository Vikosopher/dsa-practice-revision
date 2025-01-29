package linkedlist.mergetwosortedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(){}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeTwoSortedList {

    // time complexity : O(m + n), where m is the number of nodes in list1 and n is the number of nodes in list2.
    // space complexity : O(1), uses a fixed amount of extra space for the mergeHead and tail pointers.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeHead = new ListNode();
        ListNode tail = mergeHead;
        
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }

        while(list1 != null) {
            tail.next = list1;
            tail = tail.next;
            list1 = list1.next;
        }

        while(list2 != null) {
            tail.next = list2;
            tail = tail.next;
            list2 = list2.next;
        }

        return mergeHead.next;
    }
}
