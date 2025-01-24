import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){  
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 수열의 크기를 1 증가.
                }
            }
        }

        int maxSize = 0; 
        for(int i = 0; i < N; i++){
            maxSize = Math.max(maxSize, dp[i]);
        }
        
        System.out.println(maxSize);
    }
}