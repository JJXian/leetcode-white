package T236二叉树最近公共祖先;

/**
 * @Author: jjxian
 */
public class Solution {
    public TreeNode zuiJinGongGongZuXian(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = zuiJinGongGongZuXian(root.left,p,q);
        TreeNode right = zuiJinGongGongZuXian(root.right,p,q);

        if(left == null && right == null){
            return null;
        }else if(left != null && right == null){
            return left;
        }else if(left == null && right != null){
            return right;
        }

        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
