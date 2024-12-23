import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력: 정점(V), 간선(E)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        // 시작 정점
        int K = Integer.parseInt(br.readLine());

        // 그래프 인접 리스트 생성
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 1; i <= V; i++){
           graph.put(i, new ArrayList<>());
        }

        // 간선 정보 입력
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, w}); // u에 정점 v와 가중치 w를 저장
        }

        // 다익스트라 알고리즘 호출
        int[] dist = dijkstra(V, K, graph);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(dist[i] == INF){
                sb.append("INF\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int[] dijkstra(int V, int start, Map<Integer, List<int[]>> graph){ 
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF); // 최단 거리 초기화
        dist[start] = 0; 

        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0}); // 시작점 추가
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curVertex = cur[0]; // 간선
            int curWeight = cur[1]; // 가중치

            // 이미 처리된 경우 건너뛰기
            if(curWeight > dist[curVertex]) continue;

            // 현재 정점과 연결된 모든 간선 확인
            for(int[] edge: graph.getOrDefault(curVertex, Collections.emptyList())){
                int nextVertex = edge[0];
                int nextWeight = curWeight + edge[1];

                if(nextWeight < dist[nextVertex]){
                    dist[nextVertex] = nextWeight;
                    pq.add(new int[]{nextVertex, nextWeight});
                }
            }
        }

        return dist;
    }

}