public class problem3 {
    public static int[] firstSolution(int size) {
        int[] board = new int[size];
        java.util.Arrays.fill(board, -1);

        boolean[] columns = new boolean[size];
        boolean[] mainDiagonals = new boolean[2 * size - 1];
        boolean[] antiDiagonals = new boolean[2 * size - 1];

        if (solve(0, size, board, columns, mainDiagonals, antiDiagonals, null)) {
            return board;
        }
        return new int[0];
    }

    public static int[] firstSolutionWithForbiddenSquares(int size, boolean[][] forbidden) {
        int[] board = new int[size];
        java.util.Arrays.fill(board, -1);

        boolean[] columns = new boolean[size];
        boolean[] mainDiagonals = new boolean[2 * size - 1];
        boolean[] antiDiagonals = new boolean[2 * size - 1];

        if (solve(0, size, board, columns, mainDiagonals, antiDiagonals, forbidden)) {
            return board;
        }
        return new int[0];
    }

    private static boolean solve(int row, int size, int[] board, boolean[] columns,
                                  boolean[] mainDiagonals, boolean[] antiDiagonals,
                                  boolean[][] forbidden) {
        if (row == size) {
            return true;
        }

        for (int col = 0; col < size; col++) {
            if (forbidden != null && forbidden[row][col]) {
                continue;
            }

            int mainIndex = row - col + size - 1;
            int antiIndex = row + col;

            if (columns[col] || mainDiagonals[mainIndex] || antiDiagonals[antiIndex]) {
                continue;
            }

            board[row] = col;
            columns[col] = true;
            mainDiagonals[mainIndex] = true;
            antiDiagonals[antiIndex] = true;

            if (solve(row + 1, size, board, columns, mainDiagonals, antiDiagonals, forbidden)) {
                return true;
            }

            board[row] = -1;
            columns[col] = false;
            mainDiagonals[mainIndex] = false;
            antiDiagonals[antiIndex] = false;
        }

        return false;
    }
}