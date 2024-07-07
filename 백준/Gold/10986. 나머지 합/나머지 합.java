import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// A[X][Y]의 값을 채우는 구간 합 공식
// A[X][Y] = A[X][Y-1] + A[X-][Y] - A[X-1][Y-1] + A[X][Y]


public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 주어진 수
        int M = Integer.parseInt(st.nextToken()); // 나누어 떨어지는 수

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        // 배열의 구간 합
        // 1부터 N까지의 배열을 만든다. 배열의 크기는 6이며 index를 1,2,3,4,5를 사용하려고 한다.
        int[] D = new int[M]; // 나머지를 저장할 배열
        D[0] = 1; // 초기값: 나머지가 0인 경우는 자기 자신만 포함

        int prefixSum = 0; // 현재까지의 누적합을 저장한다.
        long count = 0; // 결과를 담을 변수 (long으로 선언하여 오버플로우 방지)

        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(st1.nextToken());
            prefixSum = (prefixSum + current) % M;
            if (prefixSum < 0) {
                prefixSum += M;
            }
            count += D[prefixSum]; // 현재 누적합의 나머지에 대한 count를 더함
            D[prefixSum]++; // 현재 누적합의 나머지를 D에 추가
        }
        System.out.println(count);
    }
}


