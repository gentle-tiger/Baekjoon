import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] step = new int[N + 1] ;
            
        for(int i = 1; i <= N; i++){ // 코드를 직관적으로 하기 위해 1부터 시작
            step[i] = Integer.parseInt(br.readLine());
        }
        // N이 0인 경우 (계단이 없는 경우)
        if (N == 0) {
            System.out.println(0);
            return;
        }

        // N이 1인 경우
        if (N == 1) {
            System.out.println(step[1]);
            return;
        }
        // N이 2인 경우
        if (N == 2) {
            System.out.println(Math.max(step[1] + step[2], step[2]));
            return;
        }
        
        int[] dp = new int[N + 1];
        
        dp[0] = 0;
        dp[1] = step[1];
        //  두 계단을 연속해서 밟거나 두 번째 계단만 밟는 경우
        dp[2] = Math.max(step[1] + step[2] , step[2]); 
        
        for(int i = 3; i <= N; i++){
             int a = dp[i - 2] + step[i]; // 한 계단 건너뛰고 현재 계단을 밟는 경우
             int b = dp[i - 3] + step[i - 1] + step[i]; // 이전 두 계단을 연속해서 밟는 경우
            
             dp[i] = Math.max(a, b);   
        }

        System.out.println(dp[N]);
    }
}