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
    private ListNode reverse_ll(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = reverse_ll(l1);
        ListNode temp2 = reverse_ll(l2);
        ListNode dummy = new ListNode(-1);
        ListNode tempdummy = dummy;
        int carry = 0;

        while (temp1 != null || temp2 != null || carry > 0) {
            int val1 = (temp1 != null) ? temp1.val : 0;
            int val2 = (temp2 != null) ? temp2.val : 0;
            int sum = val1 + val2 + carry;

            tempdummy.next = new ListNode(sum % 10);
            tempdummy = tempdummy.next;
            carry = sum / 10;

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }

        return reverse_ll(dummy.next);
    }
}