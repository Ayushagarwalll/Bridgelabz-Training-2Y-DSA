import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem5 {

    static class Node {
        String value;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
        }
    }

    private static void inorder(Node root, List<String> out) {
        if (root == null) {
            return;
        }
        inorder(root.left, out);
        out.add(root.value);
        inorder(root.right, out);
    }

    private static void preorder(Node root, List<String> out) {
        if (root == null) {
            return;
        }
        out.add(root.value);
        preorder(root.left, out);
        preorder(root.right, out);
    }

    private static void postorder(Node root, List<String> out) {
        if (root == null) {
            return;
        }
        postorder(root.left, out);
        postorder(root.right, out);
        out.add(root.value);
    }

    private static int apply(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    private static int evaluatePostfix(List<String> postfix) {
        Stack<Integer> stack = new Stack<>();
        for (String token : postfix) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(apply(left, right, token));
            }
        }
        return stack.pop();
    }

    private static String infixWithParentheses(Node root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return root.value;
        }
        return "(" + infixWithParentheses(root.left) + " " + root.value + " " + infixWithParentheses(root.right) + ")";
    }

    public static void main(String[] args) {
        Node root = new Node("*");
        root.left = new Node("+");
        root.right = new Node("-");
        root.left.left = new Node("3");
        root.left.right = new Node("5");
        root.right.left = new Node("8");
        root.right.right = new Node("2");

        List<String> in = new ArrayList<>();
        List<String> pre = new ArrayList<>();
        List<String> post = new ArrayList<>();

        inorder(root, in);
        preorder(root, pre);
        postorder(root, post);

        System.out.println("Problem 5: Expression Tree Evaluation");
        System.out.println("a) Postorder (postfix): " + String.join(" ", post));
        System.out.println("   Explanation: operands come before operator, matching postfix notation.");
        System.out.println("b) Inorder with parentheses (infix): " + infixWithParentheses(root));
        System.out.println("c) Preorder (prefix): " + String.join(" ", pre));
        System.out.println("d) Stack-based postorder evaluation result: " + evaluatePostfix(post));
        System.out.println("   Algorithm: push operands, on operator pop 2, apply, push result.");

        Node expr = new Node("-");
        expr.left = new Node("+");
        expr.right = new Node("e");
        expr.left.left = new Node("*");
        expr.left.right = new Node("/");
        expr.left.left.left = new Node("a");
        expr.left.left.right = new Node("b");
        expr.left.right.left = new Node("c");
        expr.left.right.right = new Node("d");

        List<String> exprIn = new ArrayList<>();
        List<String> exprPre = new ArrayList<>();
        List<String> exprPost = new ArrayList<>();
        inorder(expr, exprIn);
        preorder(expr, exprPre);
        postorder(expr, exprPost);

        System.out.println("e) Expression tree for a * b + c / d - e is built as ((a*b)+(c/d))-e.");
        System.out.println("   Inorder: " + infixWithParentheses(expr));
        System.out.println("   Preorder: " + String.join(" ", exprPre));
        System.out.println("   Postorder: " + String.join(" ", exprPost));
    }
}
