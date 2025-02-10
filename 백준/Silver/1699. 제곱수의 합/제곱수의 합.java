import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
            // i % i 로 나누어 떨어지지 않는 숫자라면 -1을 해주고 dp[i] += 1을 해준다. 
            // i % i 로 나누어 떨어지는 숫자라면 N의 값을 0으로 바꾸고 dp[i] +1 을 해준다. 

        dp[0] = 0;
        
        // 구해야 하는 N 까지만 순회 
        for(int i = 1; i <= N; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}