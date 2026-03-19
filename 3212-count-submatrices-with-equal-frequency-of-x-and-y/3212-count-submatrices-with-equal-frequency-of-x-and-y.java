class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ps = new int[m][n];
        int[][] countX = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = 0;
                if (grid[i][j] == 'X') val = 1;
                else if (grid[i][j] == 'Y') val = -1;

                ps[i][j] = val;
                if (i > 0) ps[i][j] += ps[i-1][j];
                if (j > 0) ps[i][j] += ps[i][j-1];
                if (i > 0 && j > 0) ps[i][j] -= ps[i-1][j-1];

                int x = (grid[i][j] == 'X') ? 1 : 0;
                countX[i][j] = x;
                if (i > 0) countX[i][j] += countX[i-1][j];
                if (j > 0) countX[i][j] += countX[i][j-1];
                if (i > 0 && j > 0) countX[i][j] -= countX[i-1][j-1];
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ps[i][j] == 0 && countX[i][j] > 0) ans++;
            }
        }

        return ans;
    }
}