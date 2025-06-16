import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M; 
    static int[] arr;
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        arr = new int[M];
        
        dfs(1,0);
        System.out.println(sb);
    }

    static void dfs(int start, int depth){
        if(depth == M){
            for(int x : arr){
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        // start로 시작하면 
        for(int i = start; i <= N; i++){
            arr[depth] = i; 
            dfs(i + 1, depth + 1);
        }
    }
}