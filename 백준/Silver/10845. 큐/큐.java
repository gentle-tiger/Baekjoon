import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            String answer = st.nextToken();
            
            if(answer.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            }

            if(answer.equals("front")){
                if(!q.isEmpty()){
                    System.out.println(q.peek());
                }else{
                    System.out.println(-1);
                }
            }

            if(answer.equals("back")){
                if(!q.isEmpty()){
                    System.out.println(q.peekLast());
                }else{
                    System.out.println(-1);
                }
            }


            if(answer.equals("size")){
                System.out.println(q.size());
            }

            if(answer.equals("empty")){
                if(!q.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(1);
                }
            }   

            if(answer.equals("pop")){
                if(!q.isEmpty()){
                    System.out.println(q.poll());
                }else{
                    System.out.println(-1);
                }
            } 
        }
    }
}