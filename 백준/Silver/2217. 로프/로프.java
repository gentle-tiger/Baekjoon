import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
            
        }


        int maxWeight = pq.poll();
        for(int i = 2; i <= N; i++){
            int nextWeight = pq.poll();
            if(maxWeight < (nextWeight * i)){
                maxWeight = (nextWeight * i);
            }
        }
        System.out.println(maxWeight);
    }
}