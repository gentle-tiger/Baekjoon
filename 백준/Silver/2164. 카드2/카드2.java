import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        if(N == 1){
            System.out.print(q.poll());
        }
        while(!q.isEmpty()){

            if(q.size() == 2){
                q.remove();
                System.out.print(q.poll());
                return;
            }
            q.remove();
            int cur = q.poll();
            q.add(cur);
        
        }
    }
}