import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M; 
    static int[][] box;
    static int[] DX = {-1, 1, 0, 0};
    static int[] DY = {0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        box = new int[N][M];

        boolean not_tomato = true; 
        boolean ripe_tomato = true;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j = 0; j < M; j++){
               box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    q.offer(new int[]{i, j});
                    ripe_tomato = false;
                }
                // 토마토가 있다면  
                if(box[i][j] == 0) not_tomato = false; 
           } 
        }
        // 익힐 토마토가 없다면 0 반환 
        if(not_tomato){
            System.out.println("0");
            return;
        } 

        // 익은 토마토가 없다면, 모두 익히지 못하므로 -1 반환
        if(ripe_tomato){
            System.out.println("-1");
            return;
        }

        bfs();
        
        int result = 0; 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, box[i][j]);
            }
        }

        
        System.out.println(result - 1);
    }

    private static void bfs(){

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = x + DX[i];
                int ny = y + DY[i];
                if(0 <= nx && nx < N &&
                   0 <= ny && ny < M && box[nx][ny] == 0)
                {
                    box[nx][ny] = box[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}




