class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        if (!head || !head->next) return head;

        ListNode dummy(0); // Dummy head for sorted portion
        dummy.next = head;
        ListNode* lastSorted = head; 
        ListNode* curr = head->next; 

        while (curr) {
            if (lastSorted->val <= curr->val) {
                // Already in correct position
                lastSorted = lastSorted->next;
            } else {
                // Find the insertion position
                ListNode* prev = &dummy;
                while (prev->next && prev->next->val <= curr->val) {
                    prev = prev->next;
                }
                // Insert curr between prev and prev->next
                lastSorted->next = curr->next;
                curr->next = prev->next;
                prev->next = curr;
            }
            curr = lastSorted->next;
        }
        return dummy.next;
    }
};