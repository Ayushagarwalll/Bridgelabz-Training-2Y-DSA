import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    static class Node {
        String name;
        Node left;
        Node right;

        Node(String name) {
            this.name = name;
        }
    }

    private static void inorder(Node root, List<String> output) {
        if (root == null) {
            return;
        }
        inorder(root.left, output);
        output.add(root.name);
        inorder(root.right, output);
    }

    private static void preorder(Node root, List<String> output) {
        if (root == null) {
            return;
        }
        output.add(root.name);
        preorder(root.left, output);
        preorder(root.right, output);
    }

    private static void postorder(Node root, List<String> output) {
        if (root == null) {
            return;
        }
        postorder(root.left, output);
        postorder(root.right, output);
        output.add(root.name);
    }

    public static void main(String[] args) {
        Node root = new Node("root");
        root.left = new Node("home");
        root.right = new Node("var");
        root.left.left = new Node("user");
        root.left.right = new Node("docs");
        root.left.left.left = new Node("config");
        root.right.right = new Node("log");

        List<String> in = new ArrayList<>();
        List<String> pre = new ArrayList<>();
        List<String> post = new ArrayList<>();

        inorder(root, in);
        preorder(root, pre);
        postorder(root, post);

        System.out.println("Problem 2: Traversal Application");
        System.out.println("a) For alphabetical output in a BST, use Inorder traversal.");
        System.out.println("b) For total directory size, Postorder is best (sum children before parent).");
        System.out.println("c) For backup/copy from root, Preorder is best (process parent before children).");
        System.out.println("d) Inorder traversal: " + in);
        System.out.println("d) Preorder traversal: " + pre);
        System.out.println("d) Postorder traversal: " + post);
        System.out.println("e) Postorder deletion is safe because files/subdirectories are deleted before parent directory.");
    }
}
