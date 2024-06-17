import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        // 첫 번째 줄을 읽고 StringTokenizer로 분리
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int X = Integer.parseInt(st1.nextToken());

        // 두 번째 줄을 읽고 StringTokenizer로 분리
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            
            // 배열을 순회하면서 원소가 X보다 작으면 arr에 값을 추가
            int num = Integer.parseInt(st2.nextToken());
            if(num < X){
              // 공백 주기
              System.out.print(num + " ");   
            }
        }

    }

}