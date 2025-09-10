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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode next = null;

        // Find the middle of the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode middle_temp = slow;
        while (middle_temp != null) {
            next = middle_temp.next;
            middle_temp.next = prev;
            prev = middle_temp;
            middle_temp = next;
        }

        // Compare the first half and the reversed second half
        ListNode head2 = prev; // Start from the reversed second half
        ListNode head1 = head; // Start from the beginning of the list

        while (head2 != null) { // Only iterate till the end of the second half
            if (head1.val != head2.val) {
                return false; // Values don't match, not a palindrome
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return true; // All values matched, it's a palindrome
    }
}