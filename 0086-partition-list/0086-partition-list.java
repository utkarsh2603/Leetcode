class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode lessCurr = null, xCurr = null, current = head;
        ListNode lessHead = null, xHead = null;
        while (current != null) {
            if (current.val < x) {
                if (lessCurr == null) {
                    lessCurr = current;
                    lessHead = lessCurr;
                }
                else {
                    lessCurr.next = current;
                    lessCurr = lessCurr.next;
                }
            } else {
                if (xCurr == null) {
                    xCurr = current;
                    xHead = xCurr;
                }
                else {
                    xCurr.next = current;
                    xCurr = xCurr.next;
                }
            }
            current = current.next;
        }
        if (xCurr != null) xCurr.next = null;
        if (lessCurr != null) lessCurr.next = xHead;
        return lessHead != null ? lessHead : xHead;
    }
}