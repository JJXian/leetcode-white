package T105从前序和中序构造二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jjxian
 */
public class Solution {
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder,int[] inorder){
        map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);

        }
        return findNode(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    public TreeNode findNode(int[] preorder,int preBegin, int preEnd, int[] inorder,int inBegin, int inEnd){
        if(preBegin>= preEnd || inBegin >= inEnd){
            return null;
        }

        int rootIndex = map.get(preorder[preBegin]);
        TreeNode  root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(preorder,preBegin+1,preEnd,inorder,inBegin,rootIndex);
        root.right = findNode(preorder,preBegin+lenOfLeft+1,preEnd,inorder,rootIndex+1,inEnd);
        return root;
    }

}

class TreeNode{
    int val ;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
