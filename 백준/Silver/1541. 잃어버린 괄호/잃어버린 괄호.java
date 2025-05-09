import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = br.readLine();
        StringTokenizer minusToken = new StringTokenizer(answer, "-");

        int result = 0; 
        boolean isFirst = true; 

        while(minusToken.hasMoreTokens()){
            String token = minusToken.nextToken();
            // System.out.print("현재 Token값 : " + token);
            StringTokenizer plusToken = new StringTokenizer(token, "+");

            int sum = 0;
            // +로 묶여있는 토큰의 수만큼 sum
            while(plusToken.hasMoreTokens()){
                sum += Integer.parseInt(plusToken.nextToken());
            }

            // System.out.println(" |  sum = " + sum);

            if(isFirst){
                result += sum; 
                isFirst = false;
            }else{
                result -= sum; 
            }
        }
        
        System.out.println(result);
    }
}