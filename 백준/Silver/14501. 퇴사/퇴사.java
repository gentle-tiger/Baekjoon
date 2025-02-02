import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1]; //상담 시간
        int[] P = new int[N+1]; //금액
        int[] dp = new int[N+2]; // 최대 금액

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            // 상담을 진행했을 때 종료하는 날을 기준으로
            if (i + T[i] <= N + 1) { // 상담을 끝내는 날이 퇴사일 전에 끝나는 경우
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            } else {
                dp[i] = dp[i + 1]; // 상담이 퇴사일 후에 끝난다면 이 상담을 하지 않음
            }
        }
        // 최대 이익 출력
        bw.write(dp[1] + "\n");
        bw.flush();    }
}