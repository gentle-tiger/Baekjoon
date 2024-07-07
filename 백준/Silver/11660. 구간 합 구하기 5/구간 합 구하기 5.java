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

        int N = Integer.parseInt(st.nextToken()); // 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

//        System.out.println("N : " + N + " |  M : " + M);
        // 2차원 배열
        int A[][] = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

//        // 배열 출력 (테스트용)
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//        System.out.println();

        // 2차원 배열의 구간 합
        // 1부터 N까지의 배열을 만든다. 배열의 크기는
        int D[][] = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }

        // 구간 합 배열 테스트
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(D[i][j]+ " ");
//            }
//            System.out.println();
//        }

//         결과 출력
        for (int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x1  = Integer.parseInt(st2.nextToken());
            int y1  = Integer.parseInt(st2.nextToken());
            int x2 = Integer.parseInt(st2.nextToken());
            int y2 = Integer.parseInt(st2.nextToken());
            // 특정 구간의 합 배열 (x,y)  -> D[x][y] - D[x][1] - D[1][y] + D[1][1]
            // (3 4) = 42 - 6 - 10 + 1 = D[3][4] - D[3][1] - D[1][4] + D[1][1]

            // 특정 구간~ 구간 합 배열 (x1,y1) ~ (x2,y2) -> D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]
            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];

            System.out.println(result);
        }


    }
}
