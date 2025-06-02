import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M, K;
    static char[][] board; 
    static Map<String, Integer> freq = new HashMap<>();
    static final int[][] DIR = {
        {-1,-1},{-1,0},{-1,1},
        { 0,-1},        { 0,1},
        { 1,-1},{ 1,0},{ 1,1}
    };
    static char[] path = new char[5];
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for(int i = 0; i < N; i++){
           board[i] = br.readLine().toCharArray();  
        } 
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                dfs(i, j, 0);
            }
        }

        StringBuilder out = new StringBuilder();
        for(int i = 0; i < K; i++){
            out.append(freq.getOrDefault(br.readLine(), 0)).append('\n');
        }
        System.out.print(out);
    }

    static void dfs(int x, int y, int depth){
        path[depth] = board[x][y];
        freq.merge(new String(path, 0, depth + 1), 1, Integer::sum);
        if(depth == 4) return; 


        for(int[] d : DIR){
            int nx = (x + d[0] + N) % N;
            int ny = (y + d[1] + M) % M;
            dfs(nx, ny, depth + 1);
        }
    }
}