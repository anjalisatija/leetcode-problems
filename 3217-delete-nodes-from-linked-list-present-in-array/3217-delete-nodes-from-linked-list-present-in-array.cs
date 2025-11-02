/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode ModifiedList(int[] nums, ListNode head) {
        ListNode ans = null;
        ListNode child = null;
        HashSet<int> rem = new HashSet<int>(nums);
        while(head!=null)
        {
            if(!rem.Contains(head.val)) 
            {
                if(ans==null) 
                {
                    ans = new ListNode(head.val);
                    child = ans;
                }
                else 
                {
                    child.next = new ListNode(head.val);
                    child = child.next;
                }
            }
            head = head.next;
        }
        return ans;
    }
}