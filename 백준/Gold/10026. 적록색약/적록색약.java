import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        static int N; 
        static String[][] grid;
        static boolean[][] visited;
        static int[][] dist = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new String[N][N];

        for(int i = 0; i < N; i++){
            grid[i] = br.readLine().split("");
        }

        // 적록색약이 아닌 경우
        visited = new boolean[N][N];
        int normalCount = countRegions(false);

        // 적룍색약인 경우
        visited = new boolean[N][N];
        int colorBlindCount = countRegions(true);

        System.out.println(normalCount + " " + colorBlindCount);
    }

    public static int countRegions(boolean isColorBlind){
        int count = 0; 

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){

                if(!visited[i][j]){
                    bfs(i,j,isColorBlind);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(int startRow, int startCol, boolean isColorBlind){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow,startCol});
        visited[startRow][startCol] = true;
        String currentColor = grid[startRow][startCol];

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for(int[] dis : dist){
                int nextRow = row + dis[0];
                int nextCol = col + dis[1];

                if(isValid(nextRow, nextCol, currentColor, isColorBlind)){
                    visited[nextRow][nextCol] = true;
                    q.add(new int[]{nextRow, nextCol});
                }
            }
            
        }
    }

    public static boolean isValid(int row, int col, String color, boolean isColorBlind){
        if(0 > row || row >= N || 0 > col || col >= N || visited[row][col]){
            return false;
        }


        if(isColorBlind){
            if (color.equals("B")) {
                // 현재 색상이 B인 경우, 다음 색상도 B여야 함
                return grid[row][col].equals("B");
            } else {
                // 현재 색상이 R 또는 G인 경우, 다음 색상이 R 또는 G면 됨
                return grid[row][col].equals("R") || grid[row][col].equals("G");
            }
        }else{
            // 그외의 색상 처리
            if(color.equals(grid[row][col])){
                return true;
            }
        }
        return false;
    }

}