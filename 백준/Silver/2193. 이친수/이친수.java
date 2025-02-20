import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
// 2880067194370816120
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // long[] dp = new long[N + 1];

        long a = 0, b = 1;
        for(int i = 0; i <= N; i++){
            long temp = a;
            a = b;
            b = temp + a;
            // System.out.println(temp + " " + a + " " + b);
            if(i >= N){
                 System.out.println(temp);
            }
        }
        
        // dp[1] = 1;
        // dp[2] = 1;

        // if(N == 1){
        //     System.out.println(dp[1]);
        //     return;
        // }
        // if(N == 2){
        //     System.out.println(dp[2]);
        //     return;
        // }
        
        // for(int i = 3; i <= N; i++){
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        
        // System.out.println(dp[N]);



        
    }
}