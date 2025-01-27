import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    static final int MILION = 1_000_000_000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            // 문제 요구사항에 맞게 출력
            System.out.println(0);
            System.out.println(0);
            return;
        }
        int absolute = Math.abs(n);

        long[] fib = new long[absolute + 1];  // -1,000,000~1,000,000
        fib[0] = 0; 
        fib[1] = 1; 

        for(int i = 2; i <= absolute; i++){
            fib[i] = (fib[i - 1] + fib[i - 2]) % MILION;
        }
        
        long result = fib[absolute];

        int answer;
        if(n < 0){
            if((absolute % 2) == 0){
                answer = -1;
            }else{
                answer = 1;
            }
        }else{
            answer = 1;
        }

        if(result == 0){
            answer = 0;
        }

        System.out.println(answer);
        System.out.println(result);
        
        }
    }
