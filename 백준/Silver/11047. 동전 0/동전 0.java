import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 입력: 동전 종류 N, 목표 금액 K
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 동전 가치 배열
        int[] coins = new int[N];
        
        // 두 번째 줄부터 동전 가치 입력
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 최소 동전 개수
        int coinCount = 0;
        // 목표 금액을 만들기 위해 큰 동전부터 사용
        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) break;
            
            if (coins[i] <= K) {
                coinCount += K / coins[i];  // 해당 동전을 최대한 사용
                K %= coins[i];  // 남은 금액
            }
        }
        
        // 최솟값 출력
        System.out.println(coinCount);
    }
}
