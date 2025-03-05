import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++){
            height[i] = Integer.parseInt(st.nextToken());    
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() + 1;
            } else {
                result[i] = 0;
            }

            stack.push(i);
            
        }

        for(int t : result){
            System.out.print(t + " ");
        }
        
    }
}