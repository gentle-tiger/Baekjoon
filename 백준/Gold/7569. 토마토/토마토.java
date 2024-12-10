import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] var = br.readLine().split(" ");
        int M = Integer.parseInt(var[0]);
        int N = Integer.parseInt(var[1]);
        int H = Integer.parseInt(var[2]);

        // System.out.println("M :" + M + " | N  :" + N  + " | H :" + H);

        int[][][] box = new int[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[H][N][M];
        int count = 0; 
        
        // 상자값 입력받기
        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                    String[] line = br.readLine().split(" ");
                for(int m = 0; m < M; m++){
                        box[h][n][m] = Integer.parseInt(line[m]);
                        // System.out.print(line[m] + " ");
                        if(box[h][n][m] == 1){
                            q.add(new int[]{h,n,m, 0});
                            visited[h][n][m] = true;
                            // System.out.print("{"+h +","+n +","+m+"}" + " ");
                        }
                        // System.out.print("{"+ n +","+ m+"}" + " ");
                }
                    // System.out.println();
            }
            // System.out.println("----- next page -----");
        }

        
        //                위        아래     오른쪽     왼쪽        상         하
        int[][] dist = {{0, -1, 0},{0, 1, 0},{0, 0, 1},{0, 0, -1},{1, 0, 0},{-1, 0, 0}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curH = cur[0];
            int curN = cur[1];
            int curM = cur[2];
            int cnt = cur[3];
                                                            
            for(int i = 0; i < 6; i++){

                int nextH = curH + dist[i][0];
                int nextN = curN + dist[i][1];
                int nextM = curM + dist[i][2];

                if(0 <= nextH && nextH < H && 
                      0 <= nextN && nextN < N &&
                      0 <= nextM && nextM < M && box[nextH][nextN][nextM] == 0 && !visited[nextH][nextN][nextM])
                      {
                          visited[nextH][nextN][nextM] = true;
                          box[nextH][nextN][nextM] = 1;
                          q.add(new int[]{nextH, nextN, nextM, cnt + 1});
                          // System.out.print("{"+nextH +","+nextN +","+nextM + "," + cnt + "}" + " ");
                      }
            }
            count = cnt;
        }

        // 0이 남아 있으면 -1을 반환
        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                     if(box[h][n][m] == 0){
                         count = -1;
                     }
                }
            }
        }

        
        // System.out.println();
        // System.out.println("Hello world!");
        System.out.println(count);
        br.close();
        bw.flush();
        bw.close();
    }
}
