import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;        // 입력 수열 (정렬됨)
    static int[] perm;        // 현재까지 만든 순열
    static boolean[] used;    // 인덱스 사용 여부
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        perm = new int[M];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);           // 사전식 출력을 위한 정렬

        dfs(0);
        System.out.print(sb.toString());
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int v : perm) sb.append(v).append(' ');
            sb.append('\n');
            return;
        }

        int prev = -1;               // 같은 depth 에서 마지막으로 쓴 값
        for (int i = 0; i < N; i++) {
            if (used[i])        continue;      // 인덱스 중복 방지
            if (nums[i] == prev)  continue;    // 값 중복 방지

            used[i] = true;
            perm[depth] = nums[i];
            prev = nums[i];

            dfs(depth + 1);

            used[i] = false;                    // 백트래킹
        }
    }
}
