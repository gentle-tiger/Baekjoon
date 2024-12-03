import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] reader = br.readLine().split(" ");
        int N = Integer.parseInt(reader[0]);
        int K = Integer.parseInt(reader[1]);

        // N이 움직일 수 있는 방향
        int[] dist = {1 , -1, 2};

        boolean[] visited = new boolean[100001];
        visited[N] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N,0});

        while(!q.isEmpty()){
            int[] currentStep = q.poll();
            int cur = currentStep[0];
            int count = currentStep[1];
            if(cur == K) {
                System.out.print(count);
                return;
            }
 
            for(int i = 0; i < 3; i++){
                int nextStep;
                
                if(dist[i] != 2){
                     nextStep = cur + dist[i];
                 }else{
                     nextStep = cur * dist[i];
                 }
                if(0 <= nextStep && nextStep <= 100000 && !visited[nextStep]){
                    visited[nextStep] = true;
                    q.add(new int[]{nextStep, count + 1});
                }
            }
        }
        
    }
}