package T98验证二叉搜索树;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * @Author: jjxian
 */
public class Solution {

    public boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root  = stack.pop();
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root ;
            root = root.right;
        }
        return true;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val,TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
