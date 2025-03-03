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
            int answer = Integer.parseInt(br.readLine());

            if(answer != 0){
                stack.push(answer);
            }else{
                stack.pop();
            }
        }

        int result = 0;
        for(int a : stack){
            result += a;
        }
        System.out.println(result);
    }
}