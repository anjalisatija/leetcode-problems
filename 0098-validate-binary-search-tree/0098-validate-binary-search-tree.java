class Solution {

    public boolean checkBST(TreeNode node, long minval, long maxval) {
        if (node == null) {
            return true;
        }

        if (node.val >= maxval || node.val <= minval) { // out of range
            return false;
        }

        return checkBST(node.left, minval, node.val) && checkBST(node.right, node.val, maxval);
    }
//Inorder Method
    public void inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);

    }

    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE,Long.MAX_VALUE);
        // ArrayList<Integer> arr = new ArrayList<>();
        // inorder(root, arr);
        // boolean flag = true;
        // for (int i = 1; i < arr.size(); i++) {
        //     if (arr.get(i - 1) >= arr.get(i)) {//faile first useing flag bit
        //         flag = false;
        //         break;
        //     }
        // }
        // return flag;
    }
}