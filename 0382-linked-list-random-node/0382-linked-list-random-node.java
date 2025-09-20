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

    private List<Integer> list;
    private Random rand;

    // Constructor to initialize the list and random object
    public Solution(ListNode head) {
        list = new ArrayList<>();
        rand = new Random();

        // Traverse the linked list and store values in the list
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
    }

    // Method to return a random node's value
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */