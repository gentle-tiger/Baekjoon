import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int N;
    static int[][] area;
    
    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       N = Integer.parseInt(br.readLine());

       area = new int[N][N];

       int maxHeight = 0;  // 지역 내 최대 높이 확인용
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j] > maxHeight) {
                    maxHeight = area[i][j];
                }
            }
        }

        int result = 1;

        for(int waterLevel = 0; waterLevel <= maxHeight; waterLevel++){
            boolean[][] visited = new boolean[N][N];
            int safeZoneCount = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    // 현재 물 높이보다 높고, 아직 방문 안 했다면 새 BFS 시작
                    if(area[i][j] > waterLevel && !visited[i][j]){
                        bfs(i, j, waterLevel, visited);
                        safeZoneCount++;
                    }
                }
            }
            result = Math.max(result, safeZoneCount);
        }

        System.out.println(result);
    }

    static void bfs(int startRow, int startCol, int waterLevel, boolean[][] visited){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < 4; i++){
                int nextRow = row + dir[i][0];
                int nextCol = col + dir[i][1];

                // 범위 안에 있고,
                if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N){
                    // 아직 방문 X 이고, 물에 잠기지 않았다면
                    if(!visited[nextRow][nextCol] && area[nextRow][nextCol] > waterLevel){
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        
    }
}