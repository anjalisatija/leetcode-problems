class Solution {
public:
    // Helper function to find the middle of the linked list
    ListNode* findMiddle(ListNode* head, ListNode*& prev) {
        prev = nullptr;
        ListNode* slow = head;
        ListNode* fast = head;

        while (fast && fast->next) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }

        return slow;  // slow is the middle node
    }

    TreeNode* sortedListToBST(ListNode* head) {
        // Base case: empty list
        if (!head) return nullptr;

        // Base case: single node
        if (!head->next) return new TreeNode(head->val);

        ListNode* prev = nullptr;
        ListNode* mid = findMiddle(head, prev);

        // Disconnect left half from mid
        if (prev) prev->next = nullptr;

        TreeNode* root = new TreeNode(mid->val);

        // Recursively build left and right subtrees
        if (mid != head)  // important check to avoid infinite recursion
            root->left = sortedListToBST(head);

        root->right = sortedListToBST(mid->next);

        return root;
    }
};