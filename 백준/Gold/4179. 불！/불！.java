import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        char[][] miro = new char[R][C]; // 미로 정보
        Queue<int[]> fireQueue = new ArrayDeque<>(); // 불의 위치를 저장
        Queue<int[]> jihunQueue = new ArrayDeque<>(); // 지훈의 위치를 저장

        // 지훈이 초기 위치
        int jr = 0, jc = 0;

        // 미로 초기화 및 위치 저장
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                miro[r][c] = line.charAt(c);
                if (miro[r][c] == 'J') {
                    jr = r;
                    jc = c;
                    jihunQueue.add(new int[]{r, c, 0}); // 지훈 위치 및 시간 추가
                } else if (miro[r][c] == 'F') {
                    fireQueue.add(new int[]{r, c}); // 불 위치 추가
                }
            }
        }

        int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 4방향 이동

        // BFS 탐색 시작
        while (!jihunQueue.isEmpty()) {
            // 1. 불 확산
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                int[] fire = fireQueue.poll();
                int fr = fire[0];
                int fc = fire[1];

                for (int[] d : dist) {
                    int nfr = fr + d[0];
                    int nfc = fc + d[1];

                    if (nfr >= 0 && nfr < R && nfc >= 0 && nfc < C && miro[nfr][nfc] == '.') {
                        miro[nfr][nfc] = 'F';
                        fireQueue.add(new int[]{nfr, nfc});
                    }
                }
            }

            // 2. 지훈 이동
            int jihunSize = jihunQueue.size();
            for (int i = 0; i < jihunSize; i++) {
                int[] jihun = jihunQueue.poll();
                int curJr = jihun[0];
                int curJc = jihun[1];
                int days = jihun[2];

                // 탈출 성공
                if (curJr == 0 || curJr == R - 1 || curJc == 0 || curJc == C - 1) {
                    bw.write(String.valueOf(days + 1)); // 탈출까지 걸린 시간
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }

                for (int[] d : dist) {
                    int njr = curJr + d[0];
                    int njc = curJc + d[1];

                    // 이동 가능한 조건: 경계 안, 빈 공간, 불이 없는 곳
                    if (njr >= 0 && njr < R && njc >= 0 && njc < C && miro[njr][njc] == '.') {
                        miro[njr][njc] = 'J'; // 방문 처리
                        jihunQueue.add(new int[]{njr, njc, days + 1});
                    }
                }
            }
        }

        // 탈출 불가능
        bw.write("IMPOSSIBLE");
        bw.flush();
        bw.close();
        br.close();
    }
}