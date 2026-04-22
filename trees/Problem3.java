import java.util.ArrayList;
import java.util.List;

public class Problem3 {

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
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    private static void inorder(Node root, List<Integer> out) {
        if (root == null) {
            return;
        }
        inorder(root.left, out);
        out.add(root.key);
        inorder(root.right, out);
    }

    private static boolean isValidBST(Node root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.key <= min || root.key >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.key) && isValidBST(root.right, root.key, max);
    }

    private static int height(Node root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25};
        Node root = null;
        for (int value : values) {
            root = insert(root, value);
        }

        List<Integer> in = new ArrayList<>();
        inorder(root, in);

        Node invalid = new Node(50);
        invalid.left = new Node(30);
        invalid.right = new Node(70);
        invalid.left.left = new Node(20);
        invalid.left.right = new Node(65);
        invalid.right.left = new Node(60);
        invalid.right.right = new Node(80);

        System.out.println("Problem 3: BST Construction and Validation");
        System.out.println("a) Resulting BST after insertion:");
        System.out.println("               50");
        System.out.println("             /    \\");
        System.out.println("           30      70");
        System.out.println("          /  \\    /  \\");
        System.out.println("        20   40  60   80");
        System.out.println("       /  \\");
        System.out.println("     10   25");

        System.out.println("b) Search comparisons for 25: 50 -> 30 -> 20 -> 25 (found)");
        System.out.println("c) Inorder traversal (sorted): " + in);
        System.out.println("d) Given tree valid BST? " + isValidBST(invalid, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println("   Reason: Node 65 is in left subtree of 50 but is greater than 50.");

        int balancedHeight = height(root);
        int skewedHeight = values.length - 1;
        System.out.println("e) Height of constructed tree (in edges): " + balancedHeight);
        System.out.println("   Height of completely skewed BST with 9 nodes (in edges): " + skewedHeight);
    }
}
