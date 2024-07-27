package com.xian.Z2树.JZ84二叉树中和为某一值的路径三;

import com.xian.Z2树.TreeNode;

/**
 * @Author: jjxian
 */
public class Solutiion {
    int count = 0;
    int path = 0;
    public int FindPath (TreeNode root, int sum) {
        if(root == null){
            return  0;
        }
        if(findHelper(root,sum)){
            count++;
        }
        FindPath(root.left,sum);
        FindPath(root.right,sum);
        return count;

    }

    public boolean findHelper(TreeNode root,int sum){
        if(root == null){
            return false;
        }
        path += root.val;
        if(path == sum){
            return true;
        }
        findHelper(root.left,sum);
        findHelper(root.right,sum);
        path -= root.val;
        return false;
    }

}
