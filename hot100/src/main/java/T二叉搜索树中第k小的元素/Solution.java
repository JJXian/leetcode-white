package T二叉搜索树中第k小的元素;

/**
 * @Author: jjxian
 */
public class Solution {
    int time = 0;
    int res ;
    public int kthElement(TreeNode root,int k){
        res = Integer.MAX_VALUE;
        inOrder(root,k);
        return res;
    }
    public  void inOrder(TreeNode root, int k ){
        if(root == null){
            return ;
        }
        inOrder(root.left,k);
        if(++time == k){
            res = root.val;
        }
        inOrder(root.right,k);
    }


}

class TreeNode{
    int val;
    TreeNode left ;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
