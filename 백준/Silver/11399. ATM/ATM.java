import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] times = new int[N];

        String[] arr = br.readLine().split(" ");
        
        for(int i = 0; i < N; i++){
            times[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(times);

        int maxTimes = 0; 
        int curTime = 0;
        for(int t : times){
            curTime = (curTime + t);
            maxTimes += curTime;
        }

        System.out.println(maxTimes);
    }
}