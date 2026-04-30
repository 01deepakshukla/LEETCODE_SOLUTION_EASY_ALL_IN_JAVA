import java.util.*;

public class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][k + 1];
        for (int[][] mat : dp)
            for (int[] row : mat)
                Arrays.fill(row, -1);

        
        int cost = (grid[0][0] == 0 ? 0 : 1);
        int score = grid[0][0];
        if (cost <= k) dp[0][0][cost] = score;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) continue; 
                    
                    if (i + 1 < n) {
                        int addCost = (grid[i+1][j] == 0 ? 0 : 1);
                        int newCost = c + addCost;
                        if (newCost <= k)
                            dp[i+1][j][newCost] = Math.max(dp[i+1][j][newCost], dp[i][j][c] + grid[i+1][j]);
                    }
                    
                    if (j + 1 < m) {
                        int addCost = (grid[i][j+1] == 0 ? 0 : 1);
                        int newCost = c + addCost;
                        if (newCost <= k)
                            dp[i][j+1][newCost] = Math.max(dp[i][j+1][newCost], dp[i][j][c] + grid[i][j+1]);
                    }
                }
            }
        }
        int res = -1;
        for (int c = 0; c <= k; c++) {
            res = Math.max(res, dp[n-1][m-1][c]);
        }
        return res;
    }
}