// SWEA - 1226. 미로1

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            
            int[][] maze = new int[16][16];
            int startX = 0, startY = 0;
            
            for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = line.charAt(j) - '0';
                    if (maze[i][j] == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }
            
            boolean result = bfs(maze, startX, startY);
            sb.append("#").append(t).append(" ").append(result ? 1 : 0).append("\n");
        }
        
        System.out.print(sb);
    }

    public static boolean bfs(int[][] maze, int startX, int startY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[16][16];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            if (maze[x][y] == 3) {
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < 16 && ny >= 0 && ny < 16) {
                    if (!visited[nx][ny] && (maze[nx][ny] == 0 || maze[nx][ny] == 3)) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return false;
    }
}
