import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        final int MOD = 100; 

        long[] P = new long[MOD + 1];

        P[0] = 0; 
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;
        for(int i = 6; i <= MOD; i++){
            P[i] = P[i-1] + P[i-5];
            // System.out.println("P["+i+"]" + " = " + P[i]);
        }

        for(int i = 0; i < N; i++){
            int answer = Integer.parseInt(br.readLine());
            System.out.println(P[answer]);
        }
        
    }
}