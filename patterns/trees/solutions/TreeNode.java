package patterns.trees.solutions;

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

//Easy way to validate the BST is to run the inOrder traversal because that would giive the values in
//Ascending order. The key to this approach is the usage of the prev Node.
//This will store the value prior to it, and compare the value to the current node.
class Solution {
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        //If it has a PREV (only applicable for first val) and then the value is < the value before
        //Then we have something wrong. It should never be less than the value before it.
        if (prev != null && root.val <= prev.val) {
            return false;
        }

        //store the next value as prev to compare it
        prev = root;

        return isValidBST(root.right);
    }
}