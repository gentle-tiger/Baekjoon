import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1]; // dp[i] = i 를 1로 만드는데 필요한 최소 연산 횟수

        dp[1] = 0; // 1은 이미 1 이므로 연산 0회

        // i가 2부터 시작하는 이유는 dp[2]부터 구하기 때문
        // i가 N을 포함하여 순회하는 이유는 ?? 
        for(int i = 2; i <= N; i++){ 

            // 1을 빼는 연산.
            dp[i] = dp[i - 1] + 1; // dp[2] = dp[1] + 1; (2는 1에서 + 1 횟수를 추가한 값.)

            // 2로 나누어 떨어지는 경우
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // dp[i / 2] + 1 이게 뭐지? 
            }

            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}