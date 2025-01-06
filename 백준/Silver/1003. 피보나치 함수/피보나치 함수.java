import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // DP 배열 초기화
        int[][] dp = new int[41][2]; // N의 범위가 0~40
        dp[0][0] = 1; // fibonacci(0) 호출 시 0이 출력되는 횟수
        dp[0][1] = 0; // fibonacci(0) 호출 시 1이 출력되는 횟수
        
        dp[1][0] = 0; // fibonacci(1) 호출 시 0이 출력되는 횟수
        dp[1][1] = 1; // fibonacci(1) 호출 시 1이 출력되는 횟수
        

        // DP 테이블 채우기
        for(int i = 2; i <= 40; i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0]; // p[2][0] = dp[1][0] + dp[0][0]; 
            dp[i][1] = dp[i-1][1] + dp[i-2][1]; // p[40][1] = dp[39][1] + dp[38][1];        
        }
        

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        
        System.out.println(sb.toString());
    }

}