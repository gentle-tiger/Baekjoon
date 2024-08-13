import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0; i< answer.length; i++){
            if(check(places[i])) answer[i] = 1;
        }
        return answer;
    }
    
    boolean check(String[] place){
        for(int r=0; r<5; r++){
            for(int c=0; c<5; c++){
                if(place[r].charAt(c) == 'P'){
                    if(!bfs(r,c,place)) return false;
                }
            }
        }
        return true; 
    }
    
    boolean bfs(int r, int c, String[] place){
        final int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{r,c,0});
        visited[r][c] = true; 
        
        
        while(!q.isEmpty()){
            int[] cur = q.remove();
            
            for(int i=0; i<4; i++){
                int nrow = cur[0] + d[i][0];
                int ncol = cur[1] + d[i][1];
                int ndist = cur[2] + 1; 
                
                
                if(isRange(nrow,ncol) && 
                   place[nrow].charAt(ncol) != 'X' 
                   && !visited[nrow][ncol])
                {
                    if(ndist > 2) continue; 
                    
                    if(place[nrow].charAt(ncol) == 'P') return false;
                    q.add(new int[]{nrow, ncol, ndist});
                    visited[nrow][ncol] = true; 
                }
            }
        }
        return true;
    }
    
    boolean isRange(int row, int col){
        return (row >= 0) && (row < 5) && ( col >= 0) && (col < 5);
    }
}