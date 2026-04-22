public class Problem4 {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    private static Node minValueNode(Node node) {
        Node current = node;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    private static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            Node successor = minValueNode(root.right);
            root.key = successor.key;
            root.right = delete(root.right, successor.key);
        }
        return root;
    }

    private static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.key + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] initial = {15, 10, 20, 8, 12, 17, 25};
        Node root = null;
        for (int value : initial) {
            root = insert(root, value);
        }

        System.out.println("Problem 4: BST Operations");
        System.out.println("a) Delete node 10 (two children):");
        System.out.println("   Step 1: Find node 10.");
        System.out.println("   Step 2: Find inorder successor in right subtree of 10 => 12.");
        System.out.println("   Step 3: Replace 10 with 12.");
        System.out.println("   Step 4: Delete original node 12 (leaf).");
        root = delete(root, 10);

        System.out.println("   Inorder after deletion:");
        printInorder(root);
        System.out.println();

        System.out.println("b) Insert 14 into modified tree:");
        System.out.println("   Path: 15 -> 12 -> right (empty), insert 14.");
        root = insert(root, 14);
        System.out.println("   Inorder after inserting 14:");
        printInorder(root);
        System.out.println();

        System.out.println("c) Insert 9:");
        System.out.println("   Path: 15 -> 12 -> 8 -> right (empty), insert 9.");
        root = insert(root, 9);
        System.out.println("   Inorder after inserting 9:");
        printInorder(root);
        System.out.println();

        System.out.println("d) For roll numbers between 10 and 20, use inorder traversal with range pruning.");
        System.out.println("   Why: BST inorder visits keys in sorted order and can skip out-of-range subtrees.");

        System.out.println("e) Search complexity for roll 25:");
        System.out.println("   Best case: O(1) if target is at root.");
        System.out.println("   Worst case: O(n) in skewed BST.");
        System.out.println("   In balanced BST: O(log n).");
    }
}
