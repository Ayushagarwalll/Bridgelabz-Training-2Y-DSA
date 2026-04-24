import java.util.*;

public class Problem1SocialNetwork {
    private final Map<String, Set<String>> adj = new HashMap<>();

    public void addUser(String user) {
        adj.putIfAbsent(user, new HashSet<>());
    }

    // Undirected friendship edge.
    public void addFriendship(String u, String v) {
        addUser(u);
        addUser(v);
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public Set<String> getFriends(String user) {
        return adj.getOrDefault(user, Collections.emptySet());
    }

    public boolean areDirectFriends(String u, String v) {
        return adj.containsKey(u) && adj.get(u).contains(v);
    }

    public List<String> shortestPath(String source, String target) {
        if (!adj.containsKey(source) || !adj.containsKey(target)) {
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

            for (String next : adj.getOrDefault(cur, Collections.emptySet())) {
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

    public static void main(String[] args) {
        Problem1SocialNetwork g = new Problem1SocialNetwork();

        String[] users = {"Alice", "Bob", "Charlie", "David", "Eve"};
        for (String user : users) {
            g.addUser(user);
        }

        g.addFriendship("Alice", "Bob");
        g.addFriendship("Alice", "Charlie");
        g.addFriendship("Bob", "David");
        g.addFriendship("Charlie", "Eve");
        g.addFriendship("David", "Eve");

        System.out.println("Problem 1: Social Networking Graph");
        System.out.println("Representation: Adjacency List (Map<String, Set<String>>) for sparse undirected graph.");

        System.out.println("All friends of Alice: " + g.getFriends("Alice"));

        System.out.println("Are Bob and Eve directly connected? " + g.areDirectFriends("Bob", "Eve"));

        List<String> path = g.shortestPath("Alice", "Eve");
        System.out.println("Shortest path Alice -> Eve: " + path);
        if (!path.isEmpty()) {
            System.out.println("Degree of separation: " + (path.size() - 1));
        }
    }
}
