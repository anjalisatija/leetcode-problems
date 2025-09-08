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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;

        ListNode leaderNode = new ListNode(0, head);
        ListNode fast = leaderNode;

        while (fast.next != null) {
            if (fast.next.val == val) {
                fast.next = fast.next.next;
            } else {
                fast = fast.next;
            }
        }
        return leaderNode.next;
    }
}