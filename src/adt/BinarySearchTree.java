package adt;

import console.Colors;

public class BinarySearchTree implements IDataStructures, Colors {

    public static void main(String[] args) {
        System.out.println("==== BinarySearchTree demo ====");

        BinarySearchTree tree = new BinarySearchTree();

        for (int i = 0; i < 10; i++) {
            tree.insert((int) (Math.random() * 100));
        }

        System.out.println(tree);
    }

    class Node {
        int value;
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
            }
            if (left != null) {
                left.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }

    }

    Node root; // The root of the tree

    public BinarySearchTree() {
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

        return current;
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

}
