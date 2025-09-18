class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1; // start with one slot for root
        String[] nodes = preorder.split(",");
        
        for (String node : nodes) {
            if (slots == 0) return false; // if no slots left
            slots--; // consume a slot
            if (!node.equals("#")) slots += 2; // non-null node adds 2 slots
        }
        
        return slots == 0;
    }
}