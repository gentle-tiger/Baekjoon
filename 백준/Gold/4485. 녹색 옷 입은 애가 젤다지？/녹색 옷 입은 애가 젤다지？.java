import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[][] bfs_grid;
    static final int[][] DIRECTION = {{0, 1},{0, -1},{1, 0},{-1, 0}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); // 초기 N 값
        
        for(int k = 0; k < N; k++){
            if(k != 0){
               N = Integer.parseInt(br.readLine());
            }
            if (N == 0) break; // 입력 종료 조건
            
            // System.out.println("N : "+ N);
            bfs_grid = new int[N][N];
            
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                for(int j = 0; j < N; j++){
                    bfs_grid[i][j] = Integer.parseInt(st.nextToken());
                    // System.out.print(bfs_grid[i][j] + " ");
                }
                // System.out.println();
            }
            
            int result = bfs(); 
            System.out.printf("Problem %d: %d%n", k+1, result);
        }
        
    }
    public static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        int[][] minCost = new int[N][N];
        for(int[] row : minCost) Arrays.fill(row, Integer.MAX_VALUE);
        
        q.add(new int[]{0,0}); 
        minCost[0][0] = bfs_grid[0][0];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            

            for(int[] dist : DIRECTION){
                int nextRow = row + dist[0];
                int nextCol = col + dist[1];
                
                if(isValid(nextRow, nextCol)){
                    int newCost = minCost[row][col] + bfs_grid[nextRow][nextCol];

                    if(newCost < minCost[nextRow][nextCol]){
                        minCost[nextRow][nextCol] = newCost;
                        q.add(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
        return minCost[N - 1][N - 1];
    }
    
    public static boolean isValid(int row, int col){
        return 0 <= row && row < N &&
               0 <= col && col < N;
    }
}


