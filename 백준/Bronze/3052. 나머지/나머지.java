import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] remainders = new boolean[42]; // 42로 나눈 나머지를 저장할 배열

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine()); // 값을 할당 받을 때마다 N int형의 정수로 변환함.
            int remainder = N % 42; // 42로 나눈 나머지 계산
            remainders[remainder] = true; // 해당 나머지가 나왔음을 표시
        }

        int count = 0;
        for (boolean remainder : remainders) {
            if (remainder) {
                count++;
            }
        }

        System.out.println(count);
    }
}
