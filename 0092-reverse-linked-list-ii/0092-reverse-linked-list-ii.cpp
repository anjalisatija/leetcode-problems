/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    // Reverses a linked list from 'head' to 'tail' (exclusive) and returns the new head of the reversed sublist
    ListNode* Reverse(ListNode* head, ListNode* tail) {
        ListNode* prev = NULL;
        ListNode* current = head;
        ListNode* nextNode;

        while (current != NULL) {
            nextNode = current->next;
            current->next = prev;
            prev = current;
            current = nextNode;
        }
        return prev; // Return the new head of the reversed list segment
    }

    // Reverses a linked list between two positions
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if (!head || left == right) return head; // Edge case: No reversal needed

        ListNode* temp = head;
        ListNode* previous = NULL;
        ListNode* left1 = NULL;
        ListNode* right1 = NULL;
        ListNode* newhead = NULL;
        ListNode* tail = NULL;
        int count = 1;

        while (temp != NULL) {
            if (count == left - 1) {
                left1 = temp; // Node just before the left position
            } 
            if (count == left) {
                newhead = temp; // Start of the segment to be reversed
            }
            if (count == right) {
                tail = temp; // End of the segment to be reversed
                right1 = temp->next; // Node after the right position
                temp->next = NULL; // Terminate the reversed segment
                break;
            }
            temp = temp->next;
            count++;
        }

        // Reverse the segment
        ListNode* reversedHead = Reverse(newhead, right1);

        // Connect the reversed segment back to the list
        if (left1 != NULL) {
            left1->next = reversedHead;
        } else {
            head = reversedHead; // When left is 1, update the head
        }

        newhead->next = right1; // Connect the end of the reversed segment to the rest of the list

        return head;
    }
};