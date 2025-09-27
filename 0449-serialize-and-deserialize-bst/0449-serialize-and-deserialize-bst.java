/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode>que=new LinkedList<>();
        StringBuilder result=new StringBuilder();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode curr=que.poll();
            if(curr==null){
                result.append("#"+" ");
                continue;
            }
            result.append(curr.val+" ");
            que.add(curr.left);
            que.add(curr.right);
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if (data==null || data.trim().isEmpty()) return null;
    String[] value = data.split(" ");
    
    if (value[0].equals("#")) return null;  // ✅ handle root null case
    
    Queue<TreeNode> que = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.parseInt(value[0]));
    que.add(root);
    
    int i = 1;
    while (!que.isEmpty() && i < value.length) {
        TreeNode parent = que.poll();

        // Left child
        if (!value[i].equals("#")) {
            TreeNode left = new TreeNode(Integer.parseInt(value[i]));
            parent.left = left;
            que.add(left);
        }
        i++;

        // Right child
        if (i < value.length && !value[i].equals("#")) {
            TreeNode right = new TreeNode(Integer.parseInt(value[i]));
            parent.right = right;
            que.add(right);
        }
        i++;
    }
    return root;
}

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;