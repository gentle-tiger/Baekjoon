import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

        int result = 0; 
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            result += sum;

            pq.add(sum);
        }
        System.out.println(result);
    }
}