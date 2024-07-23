package com.xian.Z2树.JZ26树的子结构;



/**
 * @Author: jjxian
 */
public class Solution {
    public static void main(String[] args) {
        // 测试用例可以在这里构建
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);

        System.out.println(HasSubtree(root1, root2)); // 应该输出 true
    }


    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
//        1、有一个为空就不是子结构
        if(root1 == null || root2 == null){
            return false;
        }
//        当根相同的时候判断两个子树 递归判断root1的左和root2 等等
        return isChild(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public static boolean isChild(TreeNode root1,TreeNode root2){
//        1、root2为空 说明属于子结构
        if(root2 == null){
            return true;
        }
//        root1为空了 或者  值不相等
        if(root1 == null || root1.val != root2.val ){
            return false;
        }
        return isChild(root1.left, root2.left) && isChild(root1.right, root2.right);

    }
}
class TreeNode{
    int val;
    TreeNode left ;
    TreeNode right;
    public  TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
