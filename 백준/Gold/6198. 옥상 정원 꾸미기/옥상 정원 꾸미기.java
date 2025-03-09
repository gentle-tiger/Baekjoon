import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] build = new int[n];
        for(int i = 0; i < n; i++){
            build[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> stack = new Stack<>();
        long totalCount = 0; 
        
        for (int i = 0; i < n; i++) {
            int height = build[i]; 
            
            while (!stack.isEmpty()) {
                if (stack.peek() <= height) {
                    stack.pop();
                } else {
                    break;
                }
            }
            
            totalCount += stack.size();
            stack.push(height);
        }

        System.out.println(totalCount);
    }
}