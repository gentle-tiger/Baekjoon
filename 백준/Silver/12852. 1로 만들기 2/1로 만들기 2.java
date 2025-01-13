import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] path = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0; // 방법을 사용하지 않고 도달.  
        
        for(int i = N; i > 0; i--){
            if(dp[i] == Integer.MAX_VALUE) continue;

            if(i % 3 == 0 && dp[i /3] > dp[i] + 1){
                dp[i / 3] = dp[i] + 1;
                path[i / 3] = i; 
            }
            if(i % 2 == 0 && dp[i / 2] > dp[i] + 1){
                dp[i / 2] = dp[i] + 1;
                path[i / 2] = i; 
            }
            if(dp[i - 1] > dp[i] + 1){
                dp[i - 1] = dp[i] + 1;
                path[i - 1] = i; 
            }
        }

        bw.write(dp[1] + "\n");

        List<Integer> result = new ArrayList<>();
        int idx = 1; 
        while(idx != 0){
            result.add(idx);
            idx = path[idx];
        }

        Collections.reverse(result);
        for(int num : result){
            bw.write(num + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}