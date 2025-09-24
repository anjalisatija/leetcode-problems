class Node {
    Node[] link = new Node[2];
    public Node() {}

    boolean containsKey(int bit) {
        return link[bit] != null;
    }

    Node get(int bit) {
        return link[bit];
    }

    void put(int bit, Node node) {
        link[bit] = node;
    }
}

class Trie {
    private Node root;
    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int getMax(int num) {
        int max = 0;
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                node = node.get(1 - bit);
                max |= (1 << i);
            } else {
                node = node.get(bit);
            }
        }
        return max;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }

        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, trie.getMax(num));
        }
        return ans;
    }
}