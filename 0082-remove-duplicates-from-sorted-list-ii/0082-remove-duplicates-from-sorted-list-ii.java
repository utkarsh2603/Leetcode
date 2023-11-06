/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prevPrev = null;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            prevPrev = prev;
            prev = curr;
            int value = curr.val;
            int flag = 0;
            while (curr.next != null && curr.next.val == value) {
                curr = curr.next;
                flag = 1;
            }
            if (flag == 1) {
                if (prevPrev == null) {
                    head = curr.next;
                    prev = null;
                    prevPrev = null;
                } else {
                    prev = prevPrev;
                    prevPrev.next = curr.next;
                }
            }
            curr = curr.next;
        }

        return head;
    }
}