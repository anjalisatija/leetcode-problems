class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int lftHei = height(root.left);
        int rgtHei = height(root.right);

        if (lftHei == rgtHei) return (1 << lftHei) + countNodes(root.right);
        else return (1 << rgtHei) + countNodes(root.left);
    }

    private int height(TreeNode x) {
        int hei = 0;
        while (x != null) {
            hei++;
            x = x.left;
        }
        return hei;
    }
}