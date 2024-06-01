import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

//            int n = sc.nextInt(); // 24
//            int m = sc.nextInt(); // 18

            int min = 1; // 최대 공약수 6
            int max = 1; // 최소 공배수 72

            // 최대 공약수
            for (int i = 1; i <= Math.min(n,m); i++) {
                if(n%i == 0 && m%i == 0){
                    min = i;
                }

            }
            // 최소공배수
            max = (n * m) / min;

            System.out.println(min);
            System.out.println(max);
        }
}

// 이전에 해결하려 했던 최소공배수
//            for(int i = 1; i < 20; i++) {
//                if(n*i == m){
//                    max = n*i;
//                    System.out.println(min);
//                    System.out.println(max);
//
//                }
//            }

