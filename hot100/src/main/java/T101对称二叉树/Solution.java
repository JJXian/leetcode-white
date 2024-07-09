package T101对称二叉树;


/**
 * @Author: jjxian
 */


class Solution {
    public static void main(String[] args) {

    }

    public boolean isSy(TreeNode root){
       if(root == null){
           return true;
       }
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode leftRoot,TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null){
            return true;
        }

        if(leftRoot == null || rightRoot == null) return false;
        return leftRoot.val == rightRoot.val && isMirror(leftRoot.right,rightRoot.left)
                && isMirror(leftRoot.left,rightRoot.right);

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