import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken(); 
                
            if(command.equals("push")) {
                int x = Integer.parseInt(st.nextToken()); 
                stack.push(x);  // 스택에 값 추가
            } else if(command.equals("pop")) {
                if(stack.isEmpty()) {
                    System.out.println(-1); 
                } else {
                    System.out.println(stack.pop()); 
                }
            } else if(command.equals("size")) {
                System.out.println(stack.size());  
            } else if(command.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);  
                } else {
                    System.out.println(0); 
                }
            } else if(command.equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);  
                } else {
                    System.out.println(stack.peek()); 
                }
            }
        }
    }
}