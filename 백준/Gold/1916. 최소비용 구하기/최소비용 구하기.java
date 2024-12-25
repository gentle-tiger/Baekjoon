import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M;
    static Map<Integer, List<int[]>> graph;
    static int[] dist;
    static final int INF = 100_000_000; // 충분히 큰 값
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 5
        M = Integer.parseInt(br.readLine()); // 8

        graph = new HashMap<>();

         // 도시의 개수만큼 순회 (N을 포함)
        for(int i = 1; i <= N; i++){
            graph.put(i , new ArrayList<>());
        }

        // 입력값 저장(M개의 이동 경로 저장)
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[]{end, cost});
        }

        // 구해야할 출발지와 도착지
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        // 다익스트라 실행
        int result = dijkstra(start, end);
        System.out.println(result);
        
    }

    static int dijkstra(int start, int end){
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0; 

        // 우선순위 큐(오름차순)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curVertex = cur[0];
            int curCost = cur[1];

            // 이미 더 작은 비용으로 방문한 경우 무시
            if(curCost > dist[curVertex]) continue; 
            
            for(int[] edge : graph.getOrDefault(curVertex, Collections.emptyList())){
                int nextVertex = edge[0];
                int nextCost = curCost + edge[1];

                if(nextCost < dist[nextVertex]){
                    dist[nextVertex] = nextCost;
                    pq.add(new int[]{nextVertex, nextCost});
                }
            }
            
        }
        return dist[end];
    }

}