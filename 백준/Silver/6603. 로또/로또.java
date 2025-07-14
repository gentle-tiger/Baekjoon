import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int[] arr;
    public static int[] path;
    public static int N;
    public static final int T = 6; // 조합의 수는 최대 6임 
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        boolean state = true;
        while(state){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            
            if(N == 0){
                state = false;
                return;
            } 

            arr = new int[N];
            path = new int[T];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }


            Arrays.sort(arr);

            StringBuilder sb = new StringBuilder();
            dfs(0, 0, sb);

            System.out.println(sb);
        }
        
    }

    private static void dfs(int depth, int start, StringBuilder sb){

        if(depth == T){
            for(int x : path){
                sb.append(x).append(' ');
            }
            sb.append("\n");
            return;
        }


        for(int i = start; i < N; i++){
            path[depth] = arr[i];
            dfs(depth + 1, i + 1, sb);
        }
    }
}





