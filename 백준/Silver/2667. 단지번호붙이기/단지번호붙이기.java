import java.util.*;
import java.lang.*;
import java.io.*;

// - `int[][]` grid - 지도를 넣을 값
// - `Queue<int[]>` q - 집이 있는 곳에서 인접한 집을 확인
// - `boolena[][]` visited - 각 지도에 집 방문 표시
// - `int` homeCount - 단지에 속하는 집의 수
// - `List<Integer>` homeSortArray - homeCount를 저장할 리스트
// - `int` apartmentComplex - 단지의 개수
    
// The main method must be in a class named "Main".
class Main {
        static int N; 
        static int[][] grid; 
        static boolean[][] visited; 
        static int[][] DIRECTION = {{-1, 0},{1, 0},{0, 1},{0, -1}};
        static List<Integer> homeSortArray = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        // System.out.println("N: "+ N);
        
        for(int i = 0; i < N; i++){
            String[] row = br.readLine().split("");
            
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(row[j]); 
                // System.out.print(row[j] + " ");
            }
            // System.out.println();
        }
        
        int apartmentComplex = 0; 
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if( grid[i][j] == 1 && !visited[i][j] ){
                   bfs(i, j);
                   apartmentComplex++;
                }
            }
        }
        // 오름차순 정렬
        Collections.sort(homeSortArray);
        
        System.out.println(apartmentComplex);
        for(int apartment : homeSortArray){
            System.out.println(apartment);
        }

    }
    public static void bfs(int row, int col){
        visited[row][col] = true; 
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});
        int homeCount = 1; 
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for(int[] dist: DIRECTION){
                int nextRow = curRow + dist[0];
                int nextCol = curCol + dist[1];
                if(isValid(nextRow, nextCol)){
                    q.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                    homeCount++;
                }
                
            }
            
        }
        homeSortArray.add(homeCount);
        
    }

    public static boolean isValid(int row, int col){
        return 0 <= row && row < N &&
               0 <= col && col < N &&
               grid[row][col] == 1 && !visited[row][col];
    }
}














