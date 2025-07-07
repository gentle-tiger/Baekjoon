import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M;
    static int[] arr, path;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        path = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0,0);
        
        System.out.println(sb);
    }

    private static void dfs(int depth, int start){

        if(depth == M){
            for(int x : path){
                 sb.append(x).append(' ');
            }
            sb.append("\n");
            return;
        }


        int last = -1;
        for(int i = start; i < N; i++){

            if(last == arr[i]) continue;
            path[depth] = arr[i];
            last = arr[i];
            dfs(depth + 1, i);
        }
    }



    
}