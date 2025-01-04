import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 4을 만드는 방법 
        /*
        1,1,1,1
        1,1,2
        1,2,1
        2,1,1
        2,2
        3,1
        1,3
        : 총 7가지로 숫자가 바뀌어도 되며, 정해진 게 없을때 
        */
        // 문제에서 N이 어느 정도까지 주어지는지 조건이 명시되지 않았다면
        // 적당히 넉넉한 크기로 dp를 만든다(예: 10000).
        // 만약 문제에서 N의 최대치가 1000이라고 했다면 dp크기를 1001 정도로.
        
        int maxN = 10000;
        int[] dp = new int[maxN + 1];

        dp[0] = 1; // n=0일 때, 아무것도 더하지 않는 "1가지" 경우 
        dp[1] = 1; // n=1일 때, {1}
        dp[2] = 2; // n=2일 때, {1,1}, {2}
        
        // n=3일 때, dp[3] = dp[2] + dp[1] + dp[0]  왜지???

        for(int i = 3; i <= maxN; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }

        
    }
}