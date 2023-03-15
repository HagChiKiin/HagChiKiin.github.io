import java.util.LinkedList;
import java.util.Queue;

public class LC1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1],0});
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true; // mark as visited
        int[][] dirs = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int currX = pos[0];
            int currY = pos[1];
            int currStep = pos[2];
            for (int[] dir : dirs
            ) {
                int x = dir[0] + currX;
                int y = dir[1] + currY;
                int step = currStep + 1;
                if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length
                        || visited[x][y]
                        || maze[x][y] == '+') {
                    continue;
                }
                if (x == 0 || x == maze.length - 1 || y == 0
                        || y == maze[0].length - 1) return step;
                visited[x][y] = true;
                queue.add(new int[]{x, y, step});
            }
        }
        return -1;
    }
}
