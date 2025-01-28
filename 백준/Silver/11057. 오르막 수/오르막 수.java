import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp[i][j]: 길이가 i인 오르막 수 중 끝 자리가 j인 경우의 수
        int MOD = 10007;
        long[][] dp = new long[N + 1][10];

        // 초기값: 길이가 1인 오르막 수는 0부터 9까지 모두 1개씩 존재
        for (int j = 0; j < 10; j++) {
            dp[1][j] = 1;
        }

        // dp 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                // dp[i][j]는 dp[i-1][0]부터 dp[i-1][j]까지의 합
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;
                }
            }
        }

        // 결과 출력: 길이가 N인 오르막 수의 개수는 dp[N][0] + dp[N][1] + ... + dp[N][9]
        long result = 0;
        for (int j = 0; j < 10; j++) {
            result += dp[N][j];
            result %= MOD;
        }

        System.out.println(result);
    }
}
