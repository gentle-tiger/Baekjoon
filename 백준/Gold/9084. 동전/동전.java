import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[] coins;
    static int M;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins = new int[N];
            
            for(int n = 0; n < N; n++){
                coins[n] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            
            int[] dp = new int[M + 1];
            dp[0] = 1; 

            for(int coin : coins){
                for(int j = coin; j <= M; j++){
                    dp[j] += dp[j - coin];
                }
            }
            System.out.println(dp[M]);
        }
    }
}