import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
//        for (int i= 0; i < 50; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int X = Integer.parseInt(st.nextToken());
//            int Y = Integer.parseInt(st.nextToken());
//            int sum = X + Y;
//            System.out.println(sum);
//        }


            while ((input = br.readLine()) != null) {
              StringTokenizer st = new StringTokenizer(input);
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                int sum = X + Y;
                System.out.println(sum);
        }


            }
        }