import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long index = n % 1500000;
        long milion = 1000000;

        long[] fb = new long[(int)index + 1];

        fb[0] = 0; 
        fb[1] = 1; 
        // 피보나치 수 계산 (1000000으로 나눈 나머지)
        for(int i = 2; i <= index; i++){
            fb[i] = (fb[i - 1] + fb[i - 2]) % milion;
        }

        System.out.println(fb[(int)index]);
    }
}