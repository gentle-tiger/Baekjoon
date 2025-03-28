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
            int n  = Integer.parseInt(br.readLine());
            if(!(n == 0)){
                pq.add(n);
            }else{
                if(!pq.isEmpty()){
                    System.out.println(pq.poll());
                }else{
                    System.out.println("0");
                }
            }
        }

        
    }
}