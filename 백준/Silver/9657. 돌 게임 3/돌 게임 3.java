import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N + 1];

        // true : 상근 승 | false : 창영 승
        if (N >= 1) dp[1] = true; 
        if (N >= 2) dp[2] = false;
        if (N >= 3) dp[3] = true;
        if (N >= 4) dp[4] = true;

        for(int i = 5; i <= N; i++){
            // N-1, N-3, N-4 중 하나라도 창영이 지는 경우가 있으면 상근 승리
            if(!dp[i - 1] || !dp[i - 3] || !dp[i - 4]){
                dp[i] = true;
            }else{
                dp[i] = false;
            }
        }
        String result = dp[N] ? "SK" : "CY"; 
        System.out.println(result);
    }
}