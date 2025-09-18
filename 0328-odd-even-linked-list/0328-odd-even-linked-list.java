/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next==null) {
            return head;
        }
        ListNode curr = head;
        ListNode evenhead = null;
        ListNode seccurr = null;
        while (curr != null) {
            if (evenhead == null) {
                evenhead = curr.next;
                curr.next = curr.next.next;
                curr = curr.next;
                seccurr=evenhead;
                continue;
            }
            if (curr.next == null) {
                curr.next = evenhead;
                seccurr.next=null;
                break;
            }
            if (curr.next.next == null) {
                seccurr.next = curr.next;
                seccurr.next.next = null;
                curr.next = evenhead;
                break;
            }
            else{
            ListNode add = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            seccurr.next = add;
            seccurr = seccurr.next;
            }
        }

        return head;
    }
}