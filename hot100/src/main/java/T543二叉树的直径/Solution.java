package T543二叉树的直径;

/**
 * @Author: jjxian
 */
public class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxDep(root);
        return res-1;
    }

    public int maxDep(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDep = maxDep(root.left);
        int rightDep = maxDep(root.right);
        // 计算当前节点为根节点的直径，即左子树深度加右子树深度再加上当前节点自身的路径长度
        res = Math.max(res,leftDep+rightDep+1);
        return Math.max(leftDep,rightDep)+1;
    }
}

class TreeNode{
    int val;
    TreeNode left ;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}