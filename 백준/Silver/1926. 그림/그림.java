import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        
        String[] node = br.readLine().split(" "); 
        int N = Integer.parseInt(node[0]); // 세로 크기 n(1 ≤ n ≤ 500)
        int M = Integer.parseInt(node[1]); // 가로 크기 m(1 ≤ m ≤ 500)

        
        int[][] paper = new int[N][M]; // 도화지

        int refactor = 0;
        for(int i = 0; i < N; i++){
           String[] arr = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                int s = Integer.parseInt(arr[j]);
                paper[i][j] = s;
                if(s == 1) {
                 refactor++;
                }
                
            }
        }
        
        if(refactor == 0) {
            bw.write("0");
            bw.newLine();
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }else if (refactor == N*M) {
            bw.write("1");
            bw.newLine();
            bw.write(String.valueOf(N*M));
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        
         boolean[][] visited = new boolean[N][M]; // 방문한 위치 
         List<Integer> result = new ArrayList<>(); // 도화지의 크기를 담을 배열
        
         Queue<int[]> q = new ArrayDeque<>(); // {행, 열, 그림사이즈}
         int[][] dist = {{-1, 0},{1, 0},{0, 1},{0, -1}};
        
        int paperCount = 0; // paperCount : 그림의 개수
        
        int max = 0;  // max : 가장 큰 도화지의 크기
        int Mmax = 0; 
        
        for(int k = 0; k < N; k++){
            for(int n = 0; n < M; n++){
                // 그림이 있는데 방문하지 않았다면
                if(paper[k][n] == 1 &&!visited[k][n]){
                    paperCount++;
                    int count = 0;
                    q.add(new int[]{k,n});
                    visited[k][n] = true;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int curRow = cur[0];
                    int curCol = cur[1];
                    count++;
                    
                    for(int i = 0; i < 4; i++){
                        int nextRow = curRow + dist[i][0];
                        int nextCol = curCol + dist[i][1];
    
                       if(0 <= nextRow && nextRow < N &&
                           0 <= nextCol && nextCol < M &&
                          paper[nextRow][nextCol] == 1 && !visited[nextRow][nextCol])
                        {
                            visited[nextRow][nextCol] = true;
                            q.add(new int[]{nextRow, nextCol});
                     }
                 }
                    Mmax = Math.max(Mmax, count);
               }
            }
          }
        }
        bw.write(String.valueOf(paperCount)); // 그림의 개수
        bw.newLine();
        bw.write(String.valueOf(Mmax)); // 가장 넓은 그림의 넓이
        
        bw.flush();
        bw.close();
        br.close();
    }
}