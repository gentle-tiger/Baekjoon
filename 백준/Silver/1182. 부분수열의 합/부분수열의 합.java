import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static int N, M, C; 
    public static int[] arr; 
    public static StringBuilder sb = new StringBuilder(); 
    
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        C = 0; 
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, 0);
        
        System.out.println(C);
    }

    private static void dfs(int idx, int sum, int depth){

        if(idx == N){
            if(sum == M && depth > 0){
                C++;
            }
            return;
        }

        dfs(idx + 1, sum + arr[idx], depth + 1);
        dfs(idx + 1, sum, depth);
    }
}