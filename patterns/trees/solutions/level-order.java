package patterns.trees.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();

            for(int i = q.size(); i > 0; i--){
                TreeNode node = q.poll();
                if(node != null){
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }

            if(level.size() > 0){
                result.add(level);
            }
        }

        return result;
    }
}
