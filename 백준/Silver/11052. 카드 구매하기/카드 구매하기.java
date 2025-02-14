import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        
        int[] card = new int[N + 1];
        card[0] = 0; 

        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        
        int[] dp = new int[N + 1];
        dp[0] = 0; 

        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + card[j]);
            }
        }

        
        System.out.println(dp[N]);
    }
}