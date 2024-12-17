import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        private static int M;
        private static int N;
        private static int K;
        private static int[][] grid;
        private static int[][] dist = {{1, 0},{-1, 0},{0, 1},{0, -1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        // System.out.println(T);

        for(int t = 0; t < T; t++){

            String[] input_1 = br.readLine().split(" ");
            M = Integer.parseInt(input_1[0]); // 가로
            N = Integer.parseInt(input_1[1]); // 세로
            K = Integer.parseInt(input_1[2]); // 개수

            grid = new int[N][M];
            // Arrays.fill(grid, 0);

            for(int k = 0; k < K; k++){
                String[] input_2 = br.readLine().split(" ");
                int edge1 = Integer.parseInt(input_2[0]);
                int edge2 = Integer.parseInt(input_2[1]);

                grid[edge2][edge1] = 1; // 순서 변경해줘야 함
            }
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    // System.out.print(grid[i][j] + " ");
                }
                // System.out.println();
            }

        boolean[][] visited = new boolean[N][M];

        int count = 0;  // 필요한 지렁이 개수
            
        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                if(grid[n][m] == 1 && !visited[n][m]){
                    bfs(n, m, visited);
                    count++;
                }
            }
        }
        System.out.println(count);
        }
    }
        
    public static void bfs(int n, int m, boolean[][] visited){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n,m}); // 8 4 

        visited[n][m] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for(int i = 0; i < 4; i++){
                int nextRow = curRow + dist[i][0];
                int nextCol = curCol + dist[i][1];

                if(0 <= nextRow && nextRow < N &&
                   0 <= nextCol && nextCol < M && 
                   !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1)
                {
                    q.add(new int[]{nextRow,nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
            
        }
        
    }

        
}



        // Map<Integer,List<Integer>> graph = new HashMap<>();
        
        // for(int i = 0; i < M; i++){
        //     graph.put(i, new ArrayList<>());
        // }
 
        // for(int i = 0; i < K; i++){
        //     String[] edge = br.readLine().split(" ");
        //         int edge1 = Integer.parseInt(edge[0]);
        //         int edge2 = Integer.parseInt(edge[1]);
        //         graph.get(edge1).add(edge2);
        //         graph.get(edge2).add(edge1);
        //         System.out.println("[" + edge1 + "," + edge2 + "]");
        //     }