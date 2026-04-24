import java.util.*;

public class Problem2CoursePrerequisiteSystem {
    private final Map<String, List<String>> graph = new HashMap<>();

    public void addCourse(String course) {
        graph.putIfAbsent(course, new ArrayList<>());
    }

    // Directed edge: prerequisite -> course.
    public void addPrerequisite(String prerequisite, String course) {
        addCourse(prerequisite);
        addCourse(course);
        graph.get(prerequisite).add(course);
    }

    public boolean hasCycle() {
        Map<String, Integer> color = new HashMap<>(); // 0=unvisited, 1=visiting, 2=done
        for (String node : graph.keySet()) {
            color.put(node, 0);
        }

        for (String node : graph.keySet()) {
            if (color.get(node) == 0 && hasCycleDfs(node, color)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleDfs(String node, Map<String, Integer> color) {
        color.put(node, 1);
        for (String next : graph.getOrDefault(node, Collections.emptyList())) {
            int state = color.getOrDefault(next, 0);
            if (state == 1) {
                return true;
            }
            if (state == 0 && hasCycleDfs(next, color)) {
                return true;
            }
        }
        color.put(node, 2);
        return false;
    }

    public Set<String> allPrerequisitesFor(String targetCourse) {
        Map<String, List<String>> reverse = new HashMap<>();
        for (String course : graph.keySet()) {
            reverse.putIfAbsent(course, new ArrayList<>());
            for (String next : graph.get(course)) {
                reverse.putIfAbsent(next, new ArrayList<>());
                reverse.get(next).add(course);
            }
        }

        Set<String> result = new LinkedHashSet<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push(targetCourse);

        while (!stack.isEmpty()) {
            String cur = stack.pop();
            for (String pre : reverse.getOrDefault(cur, Collections.emptyList())) {
                if (result.add(pre)) {
                    stack.push(pre);
                }
            }
        }

        return result;
    }

    public List<String> topologicalOrder() {
        Map<String, Integer> indegree = new HashMap<>();
        for (String course : graph.keySet()) {
            indegree.putIfAbsent(course, 0);
            for (String next : graph.get(course)) {
                indegree.put(next, indegree.getOrDefault(next, 0) + 1);
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        for (Map.Entry<String, Integer> e : indegree.entrySet()) {
            if (e.getValue() == 0) {
                queue.offer(e.getKey());
            }
        }

        List<String> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            order.add(cur);
            for (String next : graph.getOrDefault(cur, Collections.emptyList())) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        if (order.size() != indegree.size()) {
            return Collections.emptyList();
        }

        return order;
    }

    public static void main(String[] args) {
        Problem2CoursePrerequisiteSystem cps = new Problem2CoursePrerequisiteSystem();

        String[] courses = {"CS101", "CS102", "CS201", "CS202", "MATH101"};
        for (String c : courses) {
            cps.addCourse(c);
        }

        cps.addPrerequisite("CS101", "CS102");
        cps.addPrerequisite("CS101", "CS201");
        cps.addPrerequisite("CS102", "CS202");
        cps.addPrerequisite("MATH101", "CS201");

        System.out.println("Problem 2: Course Prerequisite System");
        System.out.println("Representation: Directed adjacency list (prerequisite -> dependent course).\n");

        System.out.println("Has circular dependency? " + cps.hasCycle());
        System.out.println("All courses required before CS202: " + cps.allPrerequisitesFor("CS202"));
        System.out.println("One valid topological course order: " + cps.topologicalOrder());
    }
}
