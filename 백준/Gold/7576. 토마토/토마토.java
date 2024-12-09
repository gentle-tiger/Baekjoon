import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] node = br.readLine().split(" ");
        int M = Integer.parseInt(node[0]); // 6
        int N = Integer.parseInt(node[1]); // 4

        
        int[][] box = new int[N][M]; 
        Queue<int[]> q = new ArrayDeque<>();

         
        int[][] dist = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" "); 
            
            for(int j = 0 ; j < M; j++){
                box[i][j] = Integer.parseInt(line[j]);
                // System.out.print(Integer.parseInt(line[j]) + " ");
                
                if(box[i][j] == 1){
                    q.add(new int[]{i, j, 1}); // 토마토 위치 찾기
                    visited[i][j] = true; 
                    // System.out.println(" !토마토 위치 찾기 성공! ");
                }
            }
            // System.out.println();
        }


        int answer = 0; 
        while(!q.isEmpty()){

            
            int[] cur = q.poll();  // {3,5}
            int curRow = cur[0]; // 3
            int curCol = cur[1]; // 5 
            int count = cur[2];

            for(int i = 0; i < 4; i++){
                int nextRow = curRow + dist[i][0];
                int nextCol = curCol + dist[i][1];
                if(0 <= nextRow && nextRow < N && 
                   0 <= nextCol && nextCol < M &&
                   box[nextRow][nextCol] == 0 && !visited[nextRow][nextCol])
                {
                    visited[nextRow][nextCol] = true;
                    box[nextRow][nextCol] = 1; 
                    q.add(new int[]{nextRow, nextCol, count + 1});
                     if(!q.isEmpty()){
                         answer = count;
                     } 

                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                // System.out.print(box[i][j] + " ");
                if(box[i][j] == 0){
                    answer = -1;
                }
            }
            // System.out.println();
        }

        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}