import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cur = new int[N];
        for(int i = 0; i < N; i++){
            cur[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N];
        dp[0] = cur[0];
        int maxSum = dp[0];
        
        for(int i = 1; i < N; i++){ 
            dp[i] = Math.max(dp[i - 1] + cur[i], cur[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);
    }
}