import java.util.*;

public class Problem4IslandCounter {
    private static final int[][] DIRS_4 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int[][] DIRS_8 = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1},
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    public int countIslandsDfs(int[][] grid, boolean includeDiagonal) {
        int rows = grid.length;
        int cols = rows == 0 ? 0 : grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    islands++;
                    dfs(grid, visited, r, c, includeDiagonal ? DIRS_8 : DIRS_4);
                }
            }
        }
        return islands;
    }

    private void dfs(int[][] grid, boolean[][] visited, int r, int c, int[][] dirs) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || grid[r][c] == 0) {
            return;
        }

        visited[r][c] = true;
        for (int[] d : dirs) {
            dfs(grid, visited, r + d[0], c + d[1], dirs);
        }
    }

    public int countIslandsBfs(int[][] grid, boolean includeDiagonal) {
        int rows = grid.length;
        int cols = rows == 0 ? 0 : grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;
        int[][] dirs = includeDiagonal ? DIRS_8 : DIRS_4;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    islands++;
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        for (int[] d : dirs) {
                            int nr = cell[0] + d[0];
                            int nc = cell[1] + d[1];
                            if (nr >= 0 && nc >= 0 && nr < rows && nc < cols
                                    && grid[nr][nc] == 1 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }

    private static int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        return copy;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1}
        };

        Problem4IslandCounter solver = new Problem4IslandCounter();

        System.out.println("Problem 4: Island Counter");
        System.out.println("Graph model: each land cell (value 1) is a vertex; edges connect adjacent land cells.");

        int islandsDfs = solver.countIslandsDfs(copyGrid(grid), false);
        int islandsBfs = solver.countIslandsBfs(copyGrid(grid), false);

        System.out.println("Island count using DFS (4-directional): " + islandsDfs);
        System.out.println("Island count using BFS (4-directional): " + islandsBfs);

        int islandsWithDiagonal = solver.countIslandsBfs(copyGrid(grid), true);
        System.out.println("Island count with diagonal connections (8-directional): " + islandsWithDiagonal);

        System.out.println("Complexity (both DFS and BFS):");
        System.out.println("Time: O(R * C), because each cell is visited at most once.");
        System.out.println("Space: O(R * C) in worst case (visited array + recursion stack/queue).\n");
    }
}
