import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        final int MOD = 1000000000;

        long[][] dp =  new long[n + 1][10];

        // n = 1일 때는 모두 1자리수씩 가능. 
        for(int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }
        
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                // j가 0일 경우 이전 자리는 1만 올 수 있음
                if(j > 0){
                    dp[i][j] += dp[i-1][j-1]; 
                }
                // j가 9일 경우 이전 자리는 8만 올 수 있음
                if(j < 9){
                    dp[i][j] += dp[i-1][j+1];
                }
    
                dp[i][j] %= MOD;
            }
        }
        
        long result = 0;
        for(int i = 0; i <= 9; i++){
            result += dp[n][i];
            result %= MOD;
        }
        
        System.out.println(result);
        
    }
}