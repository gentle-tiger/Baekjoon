import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = br.readLine().split(" ");
            int W = Integer.parseInt(input[0]); // 너비
            int H = Integer.parseInt(input[1]); // 높이

            if (W == 0 && H == 0) break; // 종료 조건

            int[][] grid = new int[H][W];
            boolean[][] visited = new boolean[H][W];
            for (int h = 0; h < H; h++) {
                String[] row = br.readLine().split(" ");
                for (int w = 0; w < W; w++) {
                    grid[h][w] = Integer.parseInt(row[w]);
                }
            }

            // 8방향 이동
            int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
            };

            int chicken = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        chicken++;
                        Queue<int[]> q = new ArrayDeque<>();
                        q.add(new int[]{i, j});
                        visited[i][j] = true;

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int x = cur[0];
                            int y = cur[1];

                            for (int[] dir : directions) {
                                int nx = x + dir[0];
                                int ny = y + dir[1];

                                if (nx >= 0 && nx < H && ny >= 0 && ny < W &&
                                    grid[nx][ny] == 1 && !visited[nx][ny]) {
                                    q.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }
            sb.append(chicken).append("\n");
        }

        System.out.print(sb);
    }
}
