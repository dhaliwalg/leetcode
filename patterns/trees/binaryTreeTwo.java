/**
 * Need to remember that when you're splitting the tree,
 * and sending it down either side - you need to either return
 * or save the half. It always needs to do something.
 * 
 * 3 cases to handle:
 * null
 * >
 * <
 * 
 * Let the children handle themselves.
 */
package patterns.trees;

public class binaryTreeTwo {
    public class TreeNode {
        TreeNode left, right;
        int value;

        public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    TreeNode root;

    public binaryTreeTwo() {
        root = null;
    }

    public void insert(int element) {
        this.root = insertHelper(root, element);
    }

    // Ignores duplicates, but can be modified to handle as needed
    private TreeNode insertHelper(TreeNode node, int element) {
        if (node == null) {
            return new TreeNode(element);
        }

        if (element < node.value) {
            node.left = insertHelper(node.left, element);
        }

        else if (element > node.value) {
            node.right = insertHelper(node.right, element);
        }

        return node;
    }

    public void delete(int element) {
        this.root = deleteHelper(root, element);
    }

    private TreeNode deleteHelper(TreeNode node, int element) {
        if (node == null) {
            return null;
        }

        // locate the element
        if (element < node.value) {
            node.left = deleteHelper(node.left, element);
        } else if (element > node.value) {
            node.right = deleteHelper(node.right, element);
        }

        else {
            // found it, check L & R then give whatever exists
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // get lowest value in right subtree
            // aka the inorder successor
            TreeNode rightSubtree = node.right;
            while (rightSubtree.left != null) {
                rightSubtree = rightSubtree.left;
            }

            node.value = rightSubtree.value;
            node.right = deleteHelper(node.right, node.value);
        }

        return node;
    }

    public boolean search(int element) {
        return searchHelper(root, element);
    }

    private boolean searchHelper(TreeNode node, int element) {
        if (node == null) {
            return false;
        }
        // need to return the searchHelper calls, don't forget
        if (element < node.value) {
            return searchHelper(node.left, element);
        } else if (element > node.value) {
            return searchHelper(node.right, element);
        }

        return true;
    }

    public void inorderTraversal() {
        inorderHelper(root);
    }

    private void inorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderHelper(node.left);
        System.out.println(node.value);
        inorderHelper(node.right);
    }

    public void preorderTraversal() {
        preorderHelper(root);
    }

    private void preorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.value);
        preorderHelper(node.left);
        preorderHelper(node.right);
    }

    public void postorderTraversal() {
        postorderHelper(root);
    }

    private void postorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.println(node.value);
    }

}
