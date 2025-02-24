import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n;
    static int coins[];
    static int answerCoin;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){

            n = Integer.parseInt(br.readLine());
            coins = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < n; c++){
                int coin = Integer.parseInt(st.nextToken());
                coins[c] = coin;
            }

            answerCoin = Integer.parseInt(br.readLine());

            int[] dp = new int[answerCoin + 1];

            dp[0] = 1; // 왜 1인가? -> 아무 동전도 사용하지 않는 방법. 

            
            for (int coin : coins) {
                for (int i = coin; i <= answerCoin; i++) {
                    dp[i] += dp[i-coin];
                }                
            }
            System.out.println(dp[answerCoin]);
        }
        
    }
}