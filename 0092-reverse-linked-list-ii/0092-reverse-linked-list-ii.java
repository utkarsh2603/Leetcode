class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null || right==left) return head;
        boolean check = false;
        ListNode Pleft = null;
        ListNode Pright = null;
        ListNode Tleft = null;
        ListNode Tright = null;
        ListNode curr = head;
        int count = 0;
        while(curr!=null){
            count++;
            if(count==left-1)   Pleft = curr;
            if(count==right+1)  Pright = curr;          
            if(count==left)     Tleft = curr;
            if(count==right)    Tright = curr;
            curr = curr.next;
        }
        if(Tleft==head)  check = true;     
        if(Pleft!=null && Pleft.next!=null)  Pleft.next = null;
        if(Tright.next!=null) Tright.next = null;
        curr = Tleft;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }    
        if(Pleft!=null )  Pleft.next = Tright;
        Tleft.next = Pright;
        if(head.next==null || check)  return Tright;
        return head;
    }
}