import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            
            if(maxHeap.size() == 0 || num <= maxHeap.peek()){
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
            }

            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            }else if(minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");

        }
        System.out.println(sb.toString());
    }
}