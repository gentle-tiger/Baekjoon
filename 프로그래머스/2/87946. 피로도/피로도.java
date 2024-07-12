class Solution {

        int answer = 0;
   public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        backtrack(k, visited, n, dungeons, 0);

        return answer;
    }
    
        public void backtrack(int cur_k, boolean[] visited, int n, int[][] dungeons, int count) {
        // basecase
        if (count > answer) { // 백트랙 호출
            answer = count;
        }
        // recursive call
        for (int i = 0; i < n; i++) {
            if (cur_k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                // 방문했다면 피로도를 감소시키고, count를 증가시켜서 재귀함수를 재실행한다.
                backtrack(cur_k - dungeons[i][1], visited, n, dungeons, count + 1); // 상태 건네주기.
                
                // 방금 지나온 경로(true)를 돌아가면서 해당 값을 다시 false로 변환한다.
                // 재귀 호출이 종료된 후에는 상태를 되돌리기 때문에 1차원 배열로 충분합니다.
                visited[i] = false; 
            }
        }

    }
    
    
    
}