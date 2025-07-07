import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Egg {
        int dur;   // 내구도
        final int w;   // 무게
        Egg(int dur, int w) { this.dur = dur; this.w = w; }
    }

    static int N;
    static Egg[] eggs;
    static int best;      // 지금까지 최대 깨진 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()),
                              Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);
        System.out.println(best);
    }

    /** idx 번째 계란을 들 차례, cracked = 현재까지 깨진 계란 수 */
    private static void dfs(int idx, int cracked) {
        // 모든 계란을 다 집어 봤다면 결과 갱신
        if (idx == N) {
            best = Math.max(best, cracked);
            return;
        }
        // 이미 전부 깨졌다면 더 탐색할 필요 없음
        if (cracked == N) {
            best = N;
            return;
        }

        Egg cur = eggs[idx];
        // 현재 들 계란이 이미 깨졌으면 그대로 다음 단계
        if (cur.dur <= 0) {
            dfs(idx + 1, cracked);
            return;
        }

        boolean hit = false;
        for (int j = 0; j < N; j++) {
            if (j == idx || eggs[j].dur <= 0) continue;

            hit = true;
            Egg tgt = eggs[j];

            // 충돌 : 내구도 감소
            cur.dur -= tgt.w;
            tgt.dur -= cur.w;

            int newly = cracked;
            if (cur.dur <= 0) newly++;
            if (tgt.dur <= 0) newly++;

            dfs(idx + 1, newly);

            // rollback
            cur.dur += tgt.w;
            tgt.dur += cur.w;
        }

        // 칠 계란이 없었다면 그냥 넘어감
        if (!hit) dfs(idx + 1, cracked);
    }
}
