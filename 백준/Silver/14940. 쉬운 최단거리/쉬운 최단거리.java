import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                    map[i][j] = 0;
                    
                }
                if(map[i][j] == 1){
                    map[i][j] = -1;
                }
            }
        }
        
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for(int i = 0; i < 4; i++){
                int nextRow = row + dir[i][0];
                int nextCol = col + dir[i][1];

                if(0 <= nextRow && nextRow < n &&
                   0 <= nextCol && nextCol < m &&
                   !visited[nextRow][nextCol] && map[nextRow][nextCol] == -1)
                {
                    q.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true; 
                    map[nextRow][nextCol] = map[row][col] + 1;  
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j < m-1){
                    System.out.print(map[i][j] + " "); 
                }else{
                    System.out.print(map[i][j]);
                }
                
                
            }
            System.out.println();
        }
    }
}