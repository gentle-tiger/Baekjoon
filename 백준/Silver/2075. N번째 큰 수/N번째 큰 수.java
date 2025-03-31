import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j <n; j++){
                int a = Integer.parseInt(st.nextToken());
                pq.add(a);
            }
            
        }

        for(int i = 1; i <= n; i++){
            if(i == n){
                System.out.println(pq.remove());
            }else{
                pq.remove();
            }
        }
    }
}