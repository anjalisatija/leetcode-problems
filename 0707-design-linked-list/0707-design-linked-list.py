class ListNode:
    def __init__(self, val):
        self.val = val
        self.prev = None
        self.next = None
class MyLinkedList:

    def __init__(self):
        self.head=ListNode(0)
        self.tail=ListNode(0)
        
        self.head.next=self.tail
        self.tail.prev=self.head

    def get(self, index: int) -> int:
        curr=self.head.next
        while curr and index >0:
            curr=curr.next
            index-=1
        if curr and curr!=self.tail and index==0:
            return curr.val
        return -1
    

        

    def addAtHead(self, val: int) -> None:
        newnode=ListNode(val)
        newnode.prev=self.head
        newnode.next=self.head.next
        self.head.next.prev=newnode
        self.head.next=newnode
        
    def addAtTail(self, val: int) -> None:
        newnode=ListNode(val)
        newnode.next=self.tail
        newnode.prev=self.tail.prev
        self.tail.prev.next=newnode
        self.tail.prev=newnode
    def addAtIndex(self, index: int, val: int) -> None:
        next = self.head.next
        while next and index > 0:
            next = next.next
            index -= 1
        
        if next and index == 0:
            node, prev = ListNode(val), next.prev
            node.next, node.prev = next, prev
            next.prev = node
            prev.next = node

    def deleteAtIndex(self, index: int) -> None:
        node = self.head.next
        while node and index > 0:
            node = node.next
            index -= 1
        
        if node and node != self.tail and index == 0:
            node.prev.next = node.next
            node.next.prev = node.prev