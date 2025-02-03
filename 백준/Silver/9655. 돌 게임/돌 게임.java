import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] fb = new int[N + 1];

        // 상근이가 이길 경우 : 1
        // 창영이가 이길 경우 : 0
        for(int i = 1; i <= N; i++){
            if(i % 2 == 0){
                fb[i] = 0;
            }else{
                fb[i] = 1;
            }
        }
        String result = (fb[N] == 0) ? "CY" : "SK";
        System.out.println(result);
    }
}