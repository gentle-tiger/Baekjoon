import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        result = new int[M];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        dfs(0);
        
        System.out.println(sb);
    }

    public static void dfs(int depth){

        if(depth == M){
            for(int x : result){
                sb.append(x).append(' ');
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            result[depth] = arr[i];
            dfs(depth + 1);
        }        
        
    }
}