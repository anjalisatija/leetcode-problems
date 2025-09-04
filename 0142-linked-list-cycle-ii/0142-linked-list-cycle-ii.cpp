/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        // Empty list
        if(head == NULL){
            return NULL;
        }
        ListNode* slow = head;
        ListNode* fast = head;

        // Detect the cycle
        while(fast != NULL && fast->next != NULL){
            slow = slow->next;
            fast = fast->next->next;

            if(slow == fast){
                slow = head; // point the slow to the head again 

                // find the nodes where cycle begins
                while(slow != fast){
                    slow = slow->next;  
                    fast = fast->next;
                }
                return slow;  // Start of the loop
            }
        }
        return NULL; // No cycle
    }
};