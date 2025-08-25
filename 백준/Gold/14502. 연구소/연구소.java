import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M;
    static int[][] lab;
    static ArrayList<int[]> zero = new ArrayList<>(); 
    static ArrayList<int[]> virous = new ArrayList<>(); 
    static final int[] DX = {-1, 1, 0, 0};
    static final int[] DY = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());

                // 만약 빈 집(0)이라면 zero 배열에 추가 
                if(lab[i][j] == 0) zero.add(new int[]{i,j}); 
                // 바이러스(2)라면 virous 배열에 추가 
                if(lab[i][j] == 2) virous.add(new int[]{i,j}); 
            }
        }
        
        int E = zero.size(); // 이건 무슨 변수지?? 
        int answer = 0; 
        int[][] board = new int[N][M]; // 작업 보드, 벽 세우기

        // 요기 E 산정을 어떻게 하는건지 모르겠네 
        for(int i = 0; i < E - 2; i++){
            for(int j = i + 1; j < E - 1; j++){
                for(int k = j + 1; k < E; k++){

                    // A -> B 복사 
                    for(int r = 0; r < N; r++){
                        System.arraycopy(lab[r], 0, board[r], 0, M); // System.arraycopy
                    }

                    // 벽 3개 세 우기 
                    int[] a = zero.get(i);
                    int[] b = zero.get(j);
                    int[] c = zero.get(k);
                    board[a[0]][a[1]] = 1; 
                    board[b[0]][b[1]] = 1;
                    board[c[0]][c[1]] = 1;

                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    for(int[] v : virous) q.add(v);

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int row = cur[0];
                        int col = cur[1];  
                        for (int d = 0; d < 4; d++) {
                            int nr = row + DX[d];
                            int nc = col + DY[d];

                            // 왜 || 로 하지?  &&이 아니라
                            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                            if (board[nr][nc] == 0) {
                                board[nr][nc] = 2;
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }

                    // 안전영역 카운트 
                    int safe = 0; 
                    for(int row = 0; row < N; row++){
                        for(int col = 0; col < M; col++){
                            // 빈 집(0)이 보일 때마다 카운트 
                            if(board[row][col] == 0 ) safe++;
                        }
                    }
                    // 이전 값보다 안전영역이 크기면 결과값 최신화
                    if(safe > answer) answer = safe;
                }
            }
            
        }
        System.out.println(answer);
    }
}




