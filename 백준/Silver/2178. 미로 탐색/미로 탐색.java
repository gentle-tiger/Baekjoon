import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String node = br.readLine();
        String[] node_input = node.split(" ");
        int N = Integer.parseInt(node_input[0]);
        int M = Integer.parseInt(node_input[1]);

        
        int[][] miro = new int[N][M];
        for(int i = 0; i < N; i++){
            String st = br.readLine();
            for(int j = 0; j < M; j++){
                miro[i][j] = st.charAt(j) - '0';
            }
        }

        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});

        
        int[][] dist = {{0, -1},{0, 1},{1, 0},{-1, 0}};
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true; 

        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int result = cur[2];


            if(curRow == (N - 1) && curCol == (M  - 1)){
                System.out.println(result);
                return;
            }
            

            for(int i = 0; i < 4; i++){
                int nextRow = curRow + dist[i][0];
                int nextCol = curCol + dist[i][1];
                if(0 <= nextRow && nextRow < N &&
                   0 <= nextCol && nextCol < M &&
                   miro[nextRow][nextCol] == 1 && !visited[nextRow][nextCol])
                {
                    visited[nextRow][nextCol] = true; 
                    q.add(new int[]{nextRow, nextCol, result + 1});
                   }
            }
        }

    }
}