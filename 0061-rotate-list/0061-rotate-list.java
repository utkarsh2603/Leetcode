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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return head;
      ListNode temp=head;
      int length=0,a;
      while(temp!=null)
      {
          temp=temp.next;
          length++;
      }  
      if(k%length==0)return head;
      a=k%length;
      ListNode start=head,mid=head,join=head,ans=head;
      while(join.next!=null)join=join.next;
      int x=length-a;
      while(x--!=1)
      {
          mid=mid.next;
          ans=ans.next;
      }
      ans=ans.next;
      mid.next=null;
      join.next=start;
      return ans;
    }
}