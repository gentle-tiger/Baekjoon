import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] S = new int[N + 1];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        // 초기 배열
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st1.nextToken());
        }

        // 누적 합 배열  S[i] = S[i-1] + A[i-1]
        S[0] = 0;
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + A[i - 1];
        }

        // 누적 합 배열 (i,j) i부터 j까지일 때, (i,j) = S[j] S[i-1]
        for (int i = 1; i <= M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st2.nextToken());
            int Y = Integer.parseInt(st2.nextToken());

            System.out.println(S[Y]- S[X-1]);
        }
    }
}
