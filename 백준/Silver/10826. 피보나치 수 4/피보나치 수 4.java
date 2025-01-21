import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N == 0){
            bw.write("0\n");
            bw.flush();
            return;
        }

        if(N == 1){
            bw.write("1\n");
            bw.flush();
            return;     
        }
        
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ZERO;

        for(int i = 2; i <= N; i++){
            c = a.add(b);
            a = b;
            b = c;
        }
        
        bw.write(c.toString());
        bw.flush();
        bw.close();
    }
}