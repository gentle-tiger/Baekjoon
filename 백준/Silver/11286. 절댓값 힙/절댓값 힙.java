import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Comparator.comparingInt((Integer x) -> Math.abs(x))
                      .thenComparingInt(x -> x)
        );
        
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num != 0){
                pq.add(num);
            }else{
                if(pq.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(pq.poll());
                }
            }
        }
    }
}