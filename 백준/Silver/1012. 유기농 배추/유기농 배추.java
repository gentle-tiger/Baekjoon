import java.util.*;
import java.io.*;

class Main {
    static int M, N, K; // 배추밭의 가로, 세로, 배추의 개수
    static int[][] arr; // 배추밭 배열
    static boolean[][] visited; // 방문 체크 배열

    // 방향 배열 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            // 가로 M, 세로 N, 배추의 개수 K
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];

            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // x좌표
                int y = Integer.parseInt(st.nextToken()); // y좌표
                arr[y][x] = 1;  // 배추가 심어진 곳
            }

            int count = 0;  // 연결된 배추 구역의 개수

            // 모든 칸을 돌면서 아직 방문하지 않은 배추를 찾으면 DFS 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        // 새로운 구역을 찾았을 때 DFS 실행
                        dfs(i, j);
                        count++; // 구역 개수 증가
                    }
                }
            }

            // 결과 출력
            System.out.println(count);
        }
    }

    // DFS 함수 (배추가 연결된 구역을 탐색)
    public static void dfs(int x, int y) {
        visited[x][y] = true;  // 방문 표시

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열 범위 내에 있고, 배추가 심어져 있으며, 방문하지 않았다면
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);  // 재귀적으로 DFS 호출
            }
        }
    }
}
