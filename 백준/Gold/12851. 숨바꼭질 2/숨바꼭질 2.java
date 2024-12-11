import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
        
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{N, 0});
            int[] dist = {-1, 1, 2};
            int[] minTime = new int[100000 + 1];
            Arrays.fill(minTime, -1);
            minTime[N] = 0;
    
            int num = 0; // 경로의 수를 세는 변수
            int sp = -1; // 최단 시간을 기록하는 변수
    
            while(!q.isEmpty()){
                int[] cur = q.poll();
                int n = cur[0];
                int time = cur[1];

                if(n == K){
                    if(sp == -1){
                        sp = time; 
                        num = 1; 
                        
                    }else if(time == sp){
                        num++;
                    }
                    continue;
                }

                for(int i = 0; i < 3; i++){
                    int nextN;
                    if(dist[i] != 2){
                        nextN = n + dist[i];  
                    }else{
                        nextN = n * dist[i];
                    }
            
                    if(0 <= nextN && nextN <= 100000){
                        if(minTime[nextN] == -1)
                        {
                            q.add(new int[]{nextN, time + 1});
                            minTime[nextN] = time + 1;
                        } 
                        else if(time + 1 == minTime[nextN])
                        {
                            q.add(new int[]{nextN, time + 1});
                        }   
                    }
                }
            }
        System.out.println(sp);
        System.out.println(num);
    }
}
