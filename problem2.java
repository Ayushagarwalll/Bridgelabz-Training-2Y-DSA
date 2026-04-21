
public class problem2 {
    private static final int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},           {0, 1},
        {1, -1},  {1, 0},  {1, 1}
    };

    public static boolean canFormWord(char[][] grid, String word) {
        if (grid == null || grid.length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == word.charAt(0) && dfs(grid, word, row, col, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] grid, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        if (visited[row][col] || grid[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;
        for (int[] direction : DIRECTIONS) {
            if (dfs(grid, word, row + direction[0], col + direction[1], index + 1, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}