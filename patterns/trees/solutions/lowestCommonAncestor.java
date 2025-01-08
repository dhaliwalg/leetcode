package patterns.trees.solutions;

public class lowestCommonAncestor{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode() {
        }
    
        TreeNode(int val) {
            this.val = val;
        }
    
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    // Key insight: return null if no target found, otherwise return node
    //p and q are supplied by user
    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base cases
        if(root == null) return null;
        if(root == p || root == q) return root;
        
        // Look in left and right subtrees
        TreeNode left = findLowestCommonAncestor(root.left, p, q);
        TreeNode right = findLowestCommonAncestor(root.right, p, q);
        
        // If both sides returned something, this is the LCA
        if(left != null && right != null) return root;
        
        // Otherwise return whichever side found something
        return left != null ? left : right;
    }
}

/*
 * Given a binary search tree (BST) where all node values are unique, 
 * and two nodes from the tree p and q, return the lowest common ancestor (LCA) of the two nodes.

The lowest common ancestor between two nodes p and q is the lowest node in a tree T 
such that both p and q as descendants. The ancestor is allowed to be a descendant of itself.
 */