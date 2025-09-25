import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {

    private class CountNode {
        public int count;
        public Set<String> keys;
        public CountNode prev, next;

        public CountNode(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private class DoublyLinkedList {
        public CountNode head, tail;

        public DoublyLinkedList() {
            head = new CountNode(-1);
            tail = new CountNode(-1);
            head.next = tail;
            tail.prev = head;
        }

        public void addNodeAfter(CountNode newNode, CountNode prevNode) {
            newNode.next = prevNode.next;
            newNode.prev = prevNode;
            prevNode.next.prev = newNode;
            prevNode.next = newNode;
        }

        public void removeNode(CountNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private final Map<String, CountNode> keyToNode;
    private final DoublyLinkedList countList;

    public AllOne() {
        this.keyToNode = new HashMap<>();
        this.countList = new DoublyLinkedList();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(final String key) {
        CountNode node = keyToNode.get(key);
        if (node == null) {
            if (countList.head.next.count != 1) {
                node = new CountNode(1);
                countList.addNodeAfter(node, countList.head);
            } else {
                node = countList.head.next;
            }
            node.keys.add(key);
            keyToNode.put(key, node);
        } else {
            node.keys.remove(key);
            if (node.next.count != node.count + 1) {
                CountNode newNode = new CountNode(node.count + 1);
                countList.addNodeAfter(newNode, node);
            }
            node.next.keys.add(key);
            keyToNode.put(key, node.next);
            if (node.keys.isEmpty()) {
                countList.removeNode(node);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data
     * structure.
     */
    public void dec(final String key) {
        CountNode node = keyToNode.get(key);
        if (node == null)
            return;
        node.keys.remove(key);
        if (node.count == 1) {
            keyToNode.remove(key);
        } else {
            if (node.prev.count != node.count - 1) {
                CountNode newNode = new CountNode(node.count - 1);
                countList.addNodeAfter(newNode, node.prev);
            }
            node.prev.keys.add(key);
            keyToNode.put(key, node.prev);
        }
        if (node.keys.isEmpty()) {
            countList.removeNode(node);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return countList.tail.prev == countList.head ? "" : countList.tail.prev.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return countList.head.next == countList.tail ? "" : countList.head.next.keys.iterator().next();
    }

}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */