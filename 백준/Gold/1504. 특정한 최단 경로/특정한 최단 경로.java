import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int INF = 100_000_000;
    static int N, E;
    static Map<Integer,List<int[]>> graph;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new HashMap<>();
        // 정점은 1부터 N을 포함한 수까지 입력
        for(int i = 1; i <= N; i++){
            graph.put(i, new ArrayList<>());
        }

        // 간선의 개수(6)만큼만 순회
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, cost}); // get 메서드에 [] 인지 () 인지.. 헷갈림
            graph.get(v).add(new int[]{u, cost}); // 양방향 간선이기 때문에 추가한다네? 무방향? 양방향?
        }

        // 반드시 거쳐야 하는 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 여기부터 응용~ 
        
        // 각각의 최단 경로를 계산
        int[] fromStart = dijkstra(1);  // 1번 정점에서 모든 정점까지의 최단 거리
        int[] fromV1 = dijkstra(v1); // v1에서 모든 정점까지의 최단 거리
        int[] fromV2 = dijkstra(v2); // v2에서 모든 정점까지의 최단 거리

        // 두 경로의 최단 거리를 계산 
        long route1 = calculateRoute(fromStart, fromV1, fromV2, v1, v2);
        long route2 = calculateRoute(fromStart, fromV2, fromV1, v2, v1);

        // 가능한 최단 경로 중 최소값 출력 
        long result = Math.min(route1, route2);
        System.out.println(result >= INF ? -1 : result); // 경로가 없으면 -1 출력

    }

    private static int[] dijkstra(int start){
        int[] dist = new int[N + 1]; //1부터 N을 포함한 그래프이기 때문에 + 1
        Arrays.fill(dist, INF);
        dist[start] = 0; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->  Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0}); // 시작점을 뭘 넣어야 하지?? v1, v2 는 여기가 아닌 거 같은데

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curVertex = cur[0];
            int curCost = cur[1];

            // 이거 빼먹었네 이거 필수인데 // 이미 더 작은 비용으로 방문했다면 지금 가격은 필요 없겠지??
            if(curCost > dist[curVertex]) continue;
            
            // 간선을 찾아서 대입해봐야지~ 모든 간선의 값들을 다 가져온다~ curVertex를 기준으로.
            for(int[] edge : graph.getOrDefault(curVertex, Collections.emptyList())){
                int nextVertex = edge[0]; // 다음 정점(?)만 보면 됨~
                int nextCost = curCost + edge[1]; // 가격만 추가해주고

                // 기존보다 추가한 게 더 작다면 그걸로 최신화? 
                if(nextCost < dist[nextVertex]){
                    dist[nextVertex] = nextCost;
                    pq.add(new int[]{nextVertex, nextCost});
                }
            }
        }
        return dist;
    }
    
    private static long calculateRoute(int[] fromStart, int[] fromV1, int[] fromV2, int v1, int v2){
        if(fromStart[v1] == INF ||
           fromV1[v2]    == INF ||
           fromV2[N]     == INF   )
        {
            return INF;
        }
        
        return (long) fromStart[v1] + fromV1[v2] + fromV2[N];// 그런데 v1, v2, N을 넣는 기준을 잘 모르겠음.
    }
}

