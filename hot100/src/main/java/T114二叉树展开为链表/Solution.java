package T114二叉树展开为链表;

import apple.laf.JRSUIUtils;

/**
 * @Author: jjxian
 */
public class Solution {
    public void flatten(TreeNode root){
        if(root == null){
            return ;
        }
        while(root != null){


            // 如果左子树不为空
            if (root.left != null) {
                // 找到左子树的最右边节点
                TreeNode rightMost = root.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                // 将根节点的右子树移到左子树的最右边
                rightMost.right = root.right;
                // 将根节点的左子树移到右子树上
                root.right = root.left;
                root.left = null; // 将左子树置空
            }
            // 更新根节点为其原右子树的右节点
            root = root.right;
        }
    }


}

class TreeNode{
    int val;
    TreeNode left ;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}



