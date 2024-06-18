import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        
        // 들어오는 값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N은 개수
        
        // stack 정의
        Stack<Integer> stack = new Stack<>();

        // stack 값을 할당한다. 
        for (int i = 0; i < N; i++) {
            stack.push(Integer.valueOf(br.readLine()));
        }

        
        int count = 0; // 높을 경우 ++
        int max = 0; // 기준 값
        
        
        for (int i = 0; i < N; i++){
            int a = stack.pop(); // pop은 그 값을 확인하고 버린다.
            if(a > max){
                max = a;
                count++;
            }
        }

//        while(!stack.isEmpty()){
//            int a = stack.pop(); // pop을 반환하고 버린다.
//            if(a > max){
//                max = a;
//                count++;
//            }
//        }

        System.out.println(count);
    }
}
