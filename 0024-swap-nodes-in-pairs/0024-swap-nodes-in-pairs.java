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
public class Solution {

    public static ListNode swapPairs(ListNode head) {
        // paso #1
        if (head == null || head.next == null) {
            return head;
        }

        // paso #2
        ListNode home = head.next;

        // paso #3
        ListNode end = head;

        while (head != null && head.next != null) {
            // Pasos para voltear los pares de nodos
            ListNode aux = head.next; // paso #4
            end.next = aux; // paso #5
            head.next = aux.next; // paso #6
            aux.next = head; // paso #7

            // Pasos para actualizar los punteros
            end = head; // paso #8
            head = head.next; // paso #9
        }

        // retornamos el puntero home
        return home;
    }
}