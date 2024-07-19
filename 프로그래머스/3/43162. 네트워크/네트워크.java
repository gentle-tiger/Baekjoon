import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];
        
        //✅ 모든 컴퓨터를 기점으로 DFS를 수행한다. 이미 방문된 컴퓨터는 건너뛴다.
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(n, computers, visited, i);
            count++;
        }
        
        //✅ 네트워크의 개수를 반환한다. 
        return count;
    }
    
    void dfs(int n, int[][] computers, boolean[] visited, int cur) {
        visited[cur] = true;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[cur][i] == 1) {
                dfs(n, computers, visited, i);
            }
        }
    }
}