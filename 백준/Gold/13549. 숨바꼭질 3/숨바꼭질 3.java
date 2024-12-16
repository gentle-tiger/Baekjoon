import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        int[] dist = {2, -1, 1};
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N, 0});
        boolean[] visited = new boolean[100000 + 1];
        visited[N] =  true;
        
        while(true){
            int[] node = q.poll();
            int cur = node[0];
            int count = node[1];
            if(cur == K){
                System.out.println(count);
                break;
            }
            
            for(int d : dist){
                int plus = (d == 1 || d == -1) ? 1 : 0;
                int next = (d == 1 || d == -1) ? cur + d : cur * d;  
                // System.out.println("--" + next);

                // bfs
                if(0 <= next && next <= 100000 && !visited[next])
                {
                     q.add(new int[]{next, count + plus});       
                     visited[next] = true;
                }
            
            }
            
        }        
        
    }
}