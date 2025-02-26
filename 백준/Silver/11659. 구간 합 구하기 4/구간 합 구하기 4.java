import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[0] = 0; 

        // 누적합 
        // 5 9 12 14 15 
        // 먄약 3~5라면 5-3 = 
        for(int i = 1; i <= N; i++){
            dp[i] = dp[i-1] + arr[i];
            
        }
        

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = 0; 
            
            if(a < b){
                result = dp[b] - dp[a - 1];    
            }else{
                result = dp[a] - dp[b - 1];    
            }
            
            System.out.println(result);
        }
        
    }
}