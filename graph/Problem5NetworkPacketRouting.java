import java.util.*;

public class Problem5NetworkPacketRouting {
    private final List<String> routers;
    private final Map<String, Integer> indexMap;
    private final Map<String, List<String>> adjList;
    private final int[][] adjMatrix;

    public Problem5NetworkPacketRouting(List<String> routers) {
        this.routers = new ArrayList<>(routers);
        this.indexMap = new HashMap<>();
        this.adjList = new HashMap<>();

        for (int i = 0; i < routers.size(); i++) {
            indexMap.put(routers.get(i), i);
            adjList.put(routers.get(i), new ArrayList<>());
        }

        this.adjMatrix = new int[routers.size()][routers.size()];
    }

    public void addConnection(String a, String b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);

        int i = indexMap.get(a);
        int j = indexMap.get(b);
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeConnection(String a, String b) {
        adjList.get(a).remove(b);
        adjList.get(b).remove(a);

        int i = indexMap.get(a);
        int j = indexMap.get(b);
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public boolean isConnected() {
        if (routers.isEmpty()) {
            return true;
        }

        Set<String> visited = bfsVisit(routers.get(0));
        return visited.size() == routers.size();
    }

    private Set<String> bfsVisit(String start) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String next : adjList.getOrDefault(cur, Collections.emptyList())) {
                if (visited.add(next)) {
                    queue.offer(next);
                }
            }
        }

        return visited;
    }

    public List<String> minHopPath(String source, String target) {
        if (!adjList.containsKey(source) || !adjList.containsKey(target)) {
            return Collections.emptyList();
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(target)) {
                break;
            }
            for (String next : adjList.getOrDefault(cur, Collections.emptyList())) {
                if (visited.add(next)) {
                    parent.put(next, cur);
                    queue.offer(next);
                }
            }
        }

        if (!visited.contains(target)) {
            return Collections.emptyList();
        }

        List<String> path = new ArrayList<>();
        for (String at = target; at != null; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public List<List<String>> findAllAlternativePaths(String source, String target) {
        List<List<String>> allPaths = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        LinkedList<String> currentPath = new LinkedList<>();

        dfsAllPaths(source, target, visited, currentPath, allPaths);

        allPaths.sort(Comparator.comparingInt(List::size));
        return allPaths;
    }

    private void dfsAllPaths(String node, String target, Set<String> visited,
                             LinkedList<String> currentPath, List<List<String>> allPaths) {
        visited.add(node);
        currentPath.add(node);

        if (node.equals(target)) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (String next : adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    dfsAllPaths(next, target, visited, currentPath, allPaths);
                }
            }
        }

        currentPath.removeLast();
        visited.remove(node);
    }

    public void printAdjacencyList() {
        System.out.println("Adjacency List:");
        for (String router : routers) {
            System.out.println(router + " -> " + adjList.get(router));
        }
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("    ");
        for (String router : routers) {
            System.out.print(router + " ");
        }
        System.out.println();

        for (int i = 0; i < routers.size(); i++) {
            System.out.print(routers.get(i) + "  ");
            for (int j = 0; j < routers.size(); j++) {
                System.out.print(adjMatrix[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<String> routers = Arrays.asList("R1", "R2", "R3", "R4", "R5", "R6");
        Problem5NetworkPacketRouting net = new Problem5NetworkPacketRouting(routers);

        net.addConnection("R1", "R2");
        net.addConnection("R1", "R3");
        net.addConnection("R2", "R4");
        net.addConnection("R3", "R4");
        net.addConnection("R4", "R5");
        net.addConnection("R5", "R6");

        System.out.println("Problem 5: Network Packet Routing");
        net.printAdjacencyList();
        net.printAdjacencyMatrix();

        int n = routers.size();
        int e = 6;
        System.out.println("Space complexity:");
        System.out.println("Adjacency Matrix: O(V^2) = O(" + n + "^2)");
        System.out.println("Adjacency List: O(V + E) = O(" + n + " + " + e + ")");

        System.out.println("Is network connected? " + net.isConnected());

        List<String> minPath = net.minHopPath("R1", "R6");
        System.out.println("Minimum-hop path R1 -> R6: " + minPath);
        System.out.println("Minimum hops: " + (minPath.isEmpty() ? -1 : minPath.size() - 1));

        net.removeConnection("R4", "R5");
        System.out.println("\nAfter failure of connection R4-R5:");
        List<List<String>> alternatives = net.findAllAlternativePaths("R1", "R6");
        if (alternatives.isEmpty()) {
            System.out.println("No alternative path exists from R1 to R6.");
        } else {
            System.out.println("Alternative paths from R1 to R6: " + alternatives);
        }
    }
}
