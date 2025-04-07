import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){

            int N = Integer.parseInt(br.readLine());


            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            
            for(int j = 0; j < N; j++){
                long num = Integer.parseInt(st.nextToken());
                pq.add(num);
            }

            long result = 0; 
            while(pq.size() > 1){
                long first = pq.poll();
                long second = pq.poll();

                long sum = first + second;

                result += sum;

                pq.add(sum);
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
}