import java.util.*;

public class Problem3CityRoadNetwork {
    static class Edge {
        String to;
        int distanceKm;

        Edge(String to, int distanceKm) {
            this.to = to;
            this.distanceKm = distanceKm;
        }

        @Override
        public String toString() {
            return to + "(" + distanceKm + "km)";
        }
    }

    private final Map<String, List<Edge>> graph = new HashMap<>();

    public void addIntersection(String node) {
        graph.putIfAbsent(node, new ArrayList<>());
    }

    public void addOneWayRoad(String from, String to, int distanceKm) {
        addIntersection(from);
        addIntersection(to);
        graph.get(from).add(new Edge(to, distanceKm));
    }

    public void addTwoWayRoad(String a, String b, int distanceKm) {
        addOneWayRoad(a, b, distanceKm);
        addOneWayRoad(b, a, distanceKm);
    }

    public Set<String> reachableFrom(String start) {
        Set<String> visited = new LinkedHashSet<>();
        if (!graph.containsKey(start)) {
            return visited;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (Edge e : graph.getOrDefault(cur, Collections.emptyList())) {
                if (visited.add(e.to)) {
                    queue.offer(e.to);
                }
            }
        }

        return visited;
    }

    // BFS gives path with minimum edges (fewest turns/hops) in unweighted sense.
    public List<String> fewestTurnsPath(String source, String target) {
        if (!graph.containsKey(source) || !graph.containsKey(target)) {
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

            for (Edge e : graph.getOrDefault(cur, Collections.emptyList())) {
                if (visited.add(e.to)) {
                    parent.put(e.to, cur);
                    queue.offer(e.to);
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

    public static void main(String[] args) {
        Problem3CityRoadNetwork city = new Problem3CityRoadNetwork();

        city.addOneWayRoad("A", "B", 5);
        city.addTwoWayRoad("B", "C", 3);
        city.addTwoWayRoad("A", "D", 7);
        city.addOneWayRoad("D", "E", 2);
        city.addOneWayRoad("C", "E", 4);

        System.out.println("Problem 3: City Road Network");
        System.out.println("Representation: Weighted directed adjacency list.");
        System.out.println("One-way roads are single directed edges; two-way roads are two directed edges.\n");

        System.out.println("Intersections reachable from A: " + city.reachableFrom("A"));

        List<String> path = city.fewestTurnsPath("A", "E");
        System.out.println("BFS fewest-turns path A -> E: " + path);
        System.out.println("Turns/Hops in this path: " + (path.isEmpty() ? -1 : path.size() - 1));

        System.out.println("Why DFS may miss shortest-distance path:");
        System.out.println("DFS commits deeply along one branch first; it does not explore by layers, so the first path found may use more edges and may not be the minimum-distance path.");
    }
}
