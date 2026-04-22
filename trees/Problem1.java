import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        Node(String name) {
            this.name = name;
        }

        void addChild(Node child) {
            children.add(child);
        }
    }

    private static int height(Node root) {
        if (root == null || root.children.isEmpty()) {
            return 0;
        }
        int maxChildHeight = 0;
        for (Node child : root.children) {
            maxChildHeight = Math.max(maxChildHeight, height(child));
        }
        return 1 + maxChildHeight;
    }

    private static int depth(Node root, String target, int currentDepth) {
        if (root == null) {
            return -1;
        }
        if (root.name.equals(target)) {
            return currentDepth;
        }
        for (Node child : root.children) {
            int result = depth(child, target, currentDepth + 1);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }

    private static boolean findAncestors(Node root, String target, List<String> ancestors) {
        if (root == null) {
            return false;
        }
        if (root.name.equals(target)) {
            return true;
        }

        for (Node child : root.children) {
            if (findAncestors(child, target, ancestors)) {
                ancestors.add(root.name);
                return true;
            }
        }
        return false;
    }

    private static void collectLeafNodes(Node root, List<String> leaves) {
        if (root == null) {
            return;
        }
        if (root.children.isEmpty()) {
            leaves.add(root.name);
            return;
        }
        for (Node child : root.children) {
            collectLeafNodes(child, leaves);
        }
    }

    public static void main(String[] args) {
        Node ceo = new Node("CEO");
        Node cto = new Node("CTO");
        Node cfo = new Node("CFO");
        Node devLead = new Node("Dev Lead");
        Node hr = new Node("HR");
        Node dev1 = new Node("Dev1");
        Node dev2 = new Node("Dev2");

        ceo.addChild(cto);
        ceo.addChild(cfo);
        cto.addChild(devLead);
        cfo.addChild(hr);
        devLead.addChild(dev1);
        devLead.addChild(dev2);

        List<String> leafNodes = new ArrayList<>();
        collectLeafNodes(ceo, leafNodes);

        List<String> ancestorsDev1 = new ArrayList<>();
        findAncestors(ceo, "Dev1", ancestorsDev1);

        System.out.println("Problem 1: Tree Terminology Identification");
        System.out.println("a) Leaf nodes: " + leafNodes);
        System.out.println("b) Height of tree (in edges): " + height(ceo));
        System.out.println("c) Depth of Dev Lead (from root, in edges): " + depth(ceo, "Dev Lead", 0));
        System.out.println("d) Ancestors of Dev1 (nearest to farthest): " + ancestorsDev1);
        System.out.println("e) Degree of CTO: " + cto.children.size());
        System.out.println("Note: Height in levels = height(edges) + 1 = " + (height(ceo) + 1));
    }
}
