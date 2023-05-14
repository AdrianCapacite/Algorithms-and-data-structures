package adt;

import console.Colors;

public class AVLTree implements IDataStructures, Colors {

    public static void main(String[] args) {
        System.out.println("==== AVL demo ====");

        AVLTree tree = new AVLTree();

        int[] arr = {94,31,44,41,53,45,89,78,9,86};

        // for (int i = 0; i < 10; i++) {
        //     tree.insert((int) (Math.random() * 100));
        // }

        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }

        System.out.println(tree);
    }

    class Node {
        int value;
        int height;
        Node left;
        Node right;

        @Override

        public String toString() {
            StringBuilder buffer = new StringBuilder();
            print(buffer, "", "");
            return buffer.toString();
        }

        private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
            buffer.append(prefix);
            buffer.append(value);
            buffer.append('\n');
            if (right != null) {
                right.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else if (left != null) {
                buffer.append(childrenPrefix + "├── null\n");
            }
            if (left != null) {
                left.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            } else if (right != null) {
                buffer.append(childrenPrefix + "└── null\n");
            }
        }

    }

    Node root; // The root of the tree

    public AVLTree() {
        root = null;
    }

    /** Insert from root node */
    @Override
    public void insert(int element) {
        root = insert(root, element);
    }

    /**
     * Recursive insert method
     *
     * @param current
     * @param element
     * @return
     */
    public Node insert(Node current, int element) {
        // If pointer to node is null, create a new node
        if (current == null) {
            current = new Node();
            current.value = element;
            return current;
        }

        // If the element is less than the current node, insert it into the left subtree
        // Otherwise, insert it into the right subtree
        if (element <= current.value) {
            current.left = insert(current.left, element);
        }
        if (element > current.value) {
            current.right = insert(current.right, element);
        }

        return rebalance(current);
    }

    @Override
    public boolean contains(int element) {
        return contains(root, element);
    }

    public boolean contains(Node current, int element) {
        if (current == null) {
            return false;
        }

        if (element == current.value) {
            return true;
        }

        if (element < current.value) {
            return contains(current.left, element);
        } else {
            return contains(current.right, element);
        }
    }

    @Override
    public int get(Object element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public int remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public String toString() {
        // Return the string representation of the tree
        return root.toString();
    }

    // ==== AVL specific methods ====

    public void updateHeight(Node x) {
        x.height = Math.max(height(x.left), height(x.right)) + 1;
    }

    public int height(Node x) {
        return x == null ? -1 : x.height;
    }

    public int getBalance(Node x) {
        return (null == x) ? 0 : height(x.right) - height(x.left);
    }

    // Rotations
    public Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;

        // Perform rotation
        x.right = y;
        y.left = z;
        updateHeight(x);
        updateHeight(y);
        return x;
    }

    public Node rotateLeft(Node x) {
        Node y = x.right;
        Node z = y.left;

        // Perform rotation
        y.left = x;
        x.right = z;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    public Node rebalance(Node x) {
        updateHeight(x);

        // If left heavy
        // Left or right-left operation
        if (getBalance(x) > 1) {
            // System.out.println("Left heavy");
            // If right heavy
            if (getBalance(x.right) < 0) {
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        }
        // If right heavy
        // Right or left-right operation
        else if (getBalance(x) < -1) {
            // System.out.println("Right heavy");
            // If left heavy
            if (getBalance(x.left) > 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }

        return x;
    }




}
