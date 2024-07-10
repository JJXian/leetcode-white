package T102二叉树的层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: jjxian
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return  res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            // 加入结果链表
            res.add(level);
        }
        return res;
    }
}


public class TreeNode{
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

