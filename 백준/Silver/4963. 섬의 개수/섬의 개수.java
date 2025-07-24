import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int W,H;
    public static final int[] dx = {-1,  1,  0,  0, -1, -1,  1,  1};
    public static final int[] dy = { 0,  0, -1,  1, -1,  1, -1,  1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            
            String[] input = br.readLine().split(" ");
            W = Integer.parseInt(input[0]); 
            H = Integer.parseInt(input[1]); 
            
            if (W == 0 && H == 0) break;

            int[][] isLand = new int[H][W];
            boolean[][] visited = new boolean[H][W];
            for(int h = 0; h < H; h++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int w = 0; w < W; w++){
                    isLand[h][w] = Integer.parseInt(st.nextToken());
                }
            }

            

            int count = 0; 
            for(int h = 0; h < H; h++){
                for(int w = 0; w < W; w++){
                    if(!visited[h][w] && isLand[h][w] == 1){
                        dfs(w,h, isLand, visited);
                        ++count;
                    }
                }
            }

            System.out.println(count);
        }
        
        // System.out.println("Hello world!");
        
    }
    
    private static void dfs(int w, int h, int[][] isLand, boolean[][] visited){

        visited[h][w] = true;

        for(int i = 0; i < 8; i++){
            int nx = w + dx[i];
            int ny = h + dy[i];

            if(0 <= nx && nx < W && 
               0 <= ny && ny < H && !visited[ny][nx] && isLand[ny][nx] == 1){
                dfs(nx,ny,isLand,visited);
            }
        }
        
        
    }

        

}



