import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
        private static int count = 0; 
    
    public static void main(String[] args) throws IOException {

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터 수
        int computer = Integer.parseInt(br.readLine());

        // 네트워크 연결 수
        int networkCount = Integer.parseInt(br.readLine());

        // 방문 여부
        boolean[] visited = new boolean[computer + 1]; // 0 ~ 7 (총 8개)

        // 그래프 데이터 저장
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i <= computer; i++){   // 0 ~ 7
            graph.put(i, new ArrayList<>());
        }

        // 양방향 간선
        for (int i = 0; i < networkCount; i++) {
            String[] edge = br.readLine().split(" ");
            int node1 = Integer.parseInt(edge[0]);
            int node2 = Integer.parseInt(edge[1]);
            
            graph.get(node1).add(node2);
            graph.get(node2).add(node1); 
        }
        
        // DFS 호출 (예시: 1번 노드에서 시작)
        dfs(graph, 1, visited);
        System.out.println(count);
    }     


    
        public static void dfs(Map<Integer, List<Integer>> graph, int start, boolean[] visited){

            visited[start] = true; 

            // 1번부터 살펴봐야함.
            for(int next : graph.get(start)){ // 1번과 연결되어 있는 것부터 시작
                // 연결되어 있는 다른 곳을 방문하는데, 만약 방문 하지 않았다면
                if(!visited[next]){
                    dfs(graph, next, visited);
                    count ++; 
                }
                
            }
        }
}
