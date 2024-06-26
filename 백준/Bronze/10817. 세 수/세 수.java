import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[3];

        for (int i = 0; i < 3; i++) {
            if(st.hasMoreTokens()){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(numbers);
        System.out.println(numbers[1]);


    }
}


