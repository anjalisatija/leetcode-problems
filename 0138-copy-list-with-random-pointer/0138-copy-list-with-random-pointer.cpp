class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (!head) return nullptr;

        // Step 1: Insert a copy of each node after the original node
        Node* current = head;
        while (current != nullptr) {
            Node* copy = new Node(current->val);
            copy->next = current->next;
            current->next = copy;
            current = copy->next;
        }

        // Step 2: Copy the random pointers
        current = head;
        while (current != nullptr) {
            if (current->random != nullptr) {
                current->next->random = current->random->next;
            }
            current = current->next->next;
        }

        // Step 3: Separate the original list and the copied list
        Node* newHead = head->next;
        current = head;
        while (current != nullptr) {
            Node* copy = current->next;
            current->next = copy->next;
            if (copy->next != nullptr) {
                copy->next = copy->next->next;
            }
            current = current->next;
        }

        return newHead;
    }
};