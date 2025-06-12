import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] used;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        used = new boolean[N + 1];
        arr  = new int[M];

        dfs(0);
        System.out.print(sb);
    }

    // depth: 지금까지 선택한 숫자의 개수
    static void dfs(int depth) {
        if (depth == M) {
            // 완성된 수열 출력
            for (int x : arr) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 1부터 N까지 차례로 시도 → 사전 순 보장
        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                used[i] = false;  // 백트래킹
            }
        }
    }
}
