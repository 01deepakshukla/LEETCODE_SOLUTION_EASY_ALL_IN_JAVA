import java.util.*;

class Solution {
    public boolean containsCycle(char[][] grid) {
        int Y = grid.length;
        int X = grid[0].length;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                char c = grid[y][x];

                if (Character.isUpperCase(c)) continue;

                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{x, y});

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int cx = curr[0];
                    int cy = curr[1];

                    if (Character.isUpperCase(grid[cy][cx])) {
                        return true;
                    }

                    grid[cy][cx] = Character.toUpperCase(grid[cy][cx]);

                    for (int i = 0; i < 4; i++) {
                        int nx = cx + dx[i];
                        int ny = cy + dy[i];

                        if (
                            nx >= 0 && nx < X &&
                            ny >= 0 && ny < Y &&
                            grid[ny][nx] == c
                        ) {
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return false;
    }
}
