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
        dfs(0, 1);
        System.out.println(sb);

    }

      public static void dfs(int depth, int start){
          if(depth == M){
              for(int x : arr){
                  sb.append(x + " ");
              }
              sb.append("\n");
              return;
          }

          for(int i = start; i <= N; i++){
              arr[depth] = i;
              dfs(depth + 1, i);
          }
      }
}