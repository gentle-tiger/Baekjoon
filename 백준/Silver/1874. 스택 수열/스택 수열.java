import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solveStackSequence(N, arr));
    }

    private static String solveStackSequence(int N, int[] arr){
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int cur = 1; // 스택에 push할 문자
        // N = 8;
        // arr = [4, 3, 6, 8, 7, 5, 2, 1]
        for(int target : arr){
            while(cur <= target){
                stack.push(cur++);
                result.append("+\n");
            }

            if(stack.peek() == target){
               stack.pop();
                result.append("-\n");
            }else{
                return "NO";
            }
        }
        
        return result.toString();
    }
}