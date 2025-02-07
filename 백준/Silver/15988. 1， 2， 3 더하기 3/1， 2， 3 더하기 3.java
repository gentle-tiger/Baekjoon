import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        final int MOD = 1_000_000_009;
        final int CASE = 1_000_000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[CASE + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;
        
        for(int i = 5; i <= CASE; i++){
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num] % MOD);
        }
        
    }
}