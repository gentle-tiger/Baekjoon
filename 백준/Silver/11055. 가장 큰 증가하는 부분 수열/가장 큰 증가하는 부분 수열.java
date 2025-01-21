import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        for(int i = 0; i < N; i++){
            dp[i] = A[i];
        }

        for(int i = 1; i < N; i++){ // 두 번째부터 시작
            for(int j = 0; j < i; j++){ // 현재 원소부터 시작
                if(A[j] < A[i]){
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
        }

        int maxSum = dp[0]; 
        for(int i = 1; i < N; i++){
            if(maxSum < dp[i]){
                maxSum = dp[i];
            }
        }
        
        System.out.println(maxSum);
    }
}