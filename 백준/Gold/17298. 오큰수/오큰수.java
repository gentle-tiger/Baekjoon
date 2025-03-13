import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();  // 결과를 StringBuilder에 담기

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                    int idx = stack.pop();
                    result[idx] = A[i]; // top의 
           }
           stack.push(i);
       }

        for(int i = 0; i < N; i++){
            sb.append(result[i]).append(" ");  // StringBuilder에 결과를 추가
        }
                System.out.println(sb.toString());  // 한 번에 출력

    }
}