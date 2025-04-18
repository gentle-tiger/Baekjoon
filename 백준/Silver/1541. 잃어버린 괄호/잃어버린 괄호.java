import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();
        
        StringTokenizer minusTk = new StringTokenizer(answer, "-");

        int result = 0; 
        boolean isFirst = true;

        while(minusTk.hasMoreTokens()){
            String token = minusTk.nextToken();

            StringTokenizer plusTt = new StringTokenizer(token, "+");

            int sum = 0; 
            while(plusTt.hasMoreTokens()){
                sum += Integer.parseInt(plusTt.nextToken());
            }

            if(isFirst){
                result += sum;
                isFirst = false;
            }else{
                result -= sum;
            }
        }
        System.out.print(result);
    }
}