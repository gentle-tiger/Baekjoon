import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 삼각형 구조로 입력 받기
        int[][] node = new int[N][];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            node[i] = new int[i + 1]; // i번째 줄에는 i+1개의 값
            for(int j = 0; j <= i; j++){
                node[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP: 이전 행의 결과를 이용해 현재 행 갱신
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= i; j++){
                int left = 0;
                int right = 0;
                
                // j == 0 (맨 왼쪽)은 node[i-1][j-1]이 범위를 벗어남
                if(j > 0) {
                    left = node[i-1][j-1];
                }
                // j == i (맨 오른쪽)은 node[i-1][j]가 범위를 벗어날 수 있음
                if(j < i){
                    right = node[i-1][j];
                }
                
                node[i][j] += Math.max(left, right);
            }
        }

        // 마지막 줄에서 가장 큰 값 찾기
        int answer = 0;
        for(int j = 0; j < N; j++){
            answer = Math.max(answer, node[N-1][j]);
        }

        System.out.println(answer);
    }
}
