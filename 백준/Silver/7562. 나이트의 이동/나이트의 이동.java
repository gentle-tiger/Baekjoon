import java.util.*;
import java.io.*;

class Main {

    private static final int[][] dir = {
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            int L = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[L][L];
            int[][] distance = new int[L][L];
            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[] {startX, startY});
            visited[startX][startY] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                if(x == endX && y == endY){
                    System.out.println(distance[x][y]);
                    break;
                }

                for(int i = 0; i < 8; i++){
                    int nextX = x + dir[i][0];
                    int nextY = y + dir[i][1];

                    if(nextX >= 0 && nextX < L && nextY >= 0 && nextY < L && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        distance[nextX][nextY] = distance[x][y] + 1;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
        }
    }
}
