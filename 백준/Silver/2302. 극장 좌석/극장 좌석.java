import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] vip = new int[M];
        for(int i = 0; i < M; i++){
            vip[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[N + 1]; // 1~ N
        dp[0] = 1; // 좌석이 없을 때도 1인가?  
        dp[1] = 1;
        
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 1; 
        int start = 0; 
        // vip : 4, 7
        for(int i = 0; i < M; i++){
            int end = vip[i] - 1; // VIP 좌석 바로 앞까지의 구간을 설정
            result *= dp[end - start]; // 해당 구간의 배치 가짓수를 결과에 곱한다.
            start = vip[i]; // 다음 구간의 시작 좌석을 현재 VIP 좌석으로 설정
        }

        result *= dp[N - start];

        System.out.print(result);
    }
}