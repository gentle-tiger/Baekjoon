import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[][]  Arrays;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//      0부터 30이기에 총 31 개의 boolean 값을 가지고 있음.
        boolean[] arr = new boolean[31];
        for(int i = 1; i <= 28; i++){
            int N = Integer.parseInt(br.readLine());
            arr[N] = true;
        }

        for(int i = 1; i <= 30; i++){
            if(arr[i] == false){
                System.out.println(i);
            }
        }



    }
}