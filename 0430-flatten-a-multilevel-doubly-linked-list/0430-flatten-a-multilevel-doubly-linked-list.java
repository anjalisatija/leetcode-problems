/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;

                // \U0001f501 Recursively flatten the child list
                Node pro_head = flatten(curr.child);

                // \U0001f517 Connect current node to the child
                curr.next = pro_head;
                pro_head.prev = curr;
                curr.child = null;

                // \U0001f4cd Find the tail of the child list
                Node tail = pro_head;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // \U0001f517 Connect tail of child to next
                if (next != null) {
                    tail.next = next;
                    next.prev = tail;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}