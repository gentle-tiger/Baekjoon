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
        
        
        Stack<Integer> stack = new Stack<>();
        List<String> result = new ArrayList<>();

        int cur = 1; 
        
        for(int num : arr){

            while(cur <= num){
                stack.push(cur);
                result.add("+");
                cur++;
            }
            // stack 비어있지 않고, 맨 위의 값이 목표 숫자와 같다면 꺼낸다.
            if(!stack.isEmpty() && stack.peek() == num){
                stack.pop();
                result.add("-");
            }else{
                System.out.println("NO");
                return;
            }
        }

        for(String op : result){
            System.out.println(op);
        }
    }
}