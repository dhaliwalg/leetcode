package patterns.trees.solutions;

class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int val){
            this.key = val;
            left = null;
            right = null;
        }
    }

    class BST{
        Node root;

        public BST(){
            root = null;
        }

        void insertItem(int val){
            root = insertHelper(val, root);
        }

        Node insertHelper(int val, Node currNode){
            if(currNode == null){
                return new Node(val);
            }

            if (val < root.key){
                currNode.left = insertHelper(val, currNode.left);
            } else if(val > root.key){
                currNode.right = insertHelper(val, currNode.right);
            }

            return currNode;
        }

        void delete(int val){
            root = deleteHelper(val, root);
        }

        Node deleteHelper(int val, Node currNode){
            if(currNode == null){
                return currNode;
            }
            if(val < currNode.key){
                deleteHelper(val, currNode.left);
            } else if(val > currNode.key){
                deleteHelper(val, currNode.right);
            }

            //If the node has children, but we found the value.
            //We have to send the proper child.
            else{
                //If there's no left child, replace it with the right child
                if(currNode.left == null){
                    return currNode.right;
                //If there's no right child, replace it with the left child
                } else if(currNode.right == null){
                    return currNode.left;
                }

                //Node has BOTH children
                //We need to replace it with the minimum value in the right subtree
                currNode.key = minValue(currNode.right);
                //Now we delete the value that we just pulled all the way up
                currNode.right = deleteHelper(currNode.key, currNode.right);
            }

            return currNode;
        }

        //Just keep looping through the left nodes until there's nothing left
        int minValue(Node root){
            int minV = root.key;
            while(root.left != null){
                minV = root.left.key;
                root = root.left;
            }
            return minV;
        }
    }
}