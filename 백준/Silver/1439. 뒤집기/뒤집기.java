import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        
        int len = input.length();
        
        int zero = 0;
        int one = 0;

        if (input.charAt(0) == '0') {
            zero++;
        } else {
            one++;
        }

        for (int i = 1; i < len; i++) {
            if (input.charAt(i) != input.charAt(i - 1)) {
                if (input.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
        }
        
        int result = Math.min(zero, one);
        System.out.println(result);
    }
}
