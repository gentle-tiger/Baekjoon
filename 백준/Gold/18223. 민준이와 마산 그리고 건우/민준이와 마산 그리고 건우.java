import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int INF = 100_000_000;
    static int V, E, P;
    static Map<Integer,List<int[]>> graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new HashMap<>();
        for(int i = 1; i <= V; i++){
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


        // 최단 경로 계산
        int startToEnd = dijkstra(1, V);  // 1번 → V번 최단 거리
        int startToP = dijkstra(1, P);   // 1번 → P번 최단 거리
        int pToEnd = dijkstra(P, V);     // P번 → V번 최단 거리

        // 판별
        if (startToP + pToEnd == startToEnd) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }
    
    private static int dijkstra(int start, int end){
        int[] dist = new int[V + 1]; //1부터 N을 포함한 그래프이기 때문에 + 1
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
            for(int[] edge : graph.get(curVertex)){
                int nextVertex = edge[0]; // 다음 정점(?)만 보면 됨~
                int nextCost = curCost + edge[1]; // 가격만 추가해주고

                // 기존보다 추가한 게 더 작다면 그걸로 최신화? 
                if(nextCost < dist[nextVertex]){
                    dist[nextVertex] = nextCost;
                    pq.add(new int[]{nextVertex, nextCost});
                }
            }
        }
        return dist[end];
    }
}