import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수 (정점)
        int M = Integer.parseInt(st.nextToken()); // 도로 개수 (간선)
        int X = Integer.parseInt(st.nextToken()); // 파티가 열리는 마을 번호

        // 그래프 초기화
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 1; i <= N ; i++){ // N인 이유는? 
             graph.put(i , new ArrayList<>());
        }

        // 간선 정보 입력
        for(int i = 0; i < M; i++){ // 여기는 왜 0부터? 
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(start).add(new int[]{end, cost});
        }
        
        // 시작점에서 각 정점까지의 최단 거리를 저장하는 배열.
        // 거 리 정보를 지속적으로 업데이트하면서 최단 경로를 계산.

        // 1. 모든 정점에서 X로 가는 최단 거리 계산
        int[] toX = dijkstra(N, X, graph);

        // 2. X에서 모든 정점으로 가는 최단 거리 계산
        int[] fromX = dijkstra(N, X, reverseGraph(graph, N)); // 왜 X가 들어오지?

        // 3. 각 정점의 왕복 거리 계산 및 최댓값 도출
        int maxDistance = 0; 
        for(int i = 1; i <= N; i++){
            maxDistance = Math.max(maxDistance, toX[i] + fromX[i]);
        }

        // System.out.println("maxDistance: "+ maxDistance);
        System.out.println(maxDistance);
        // System.out.println("Hello world!");
    }

    static int[] dijkstra(int N, int start, Map<Integer, List<int[]>> graph){
        int[] dist = new int[N + 1]; // 왜 N이 들어오지? 
        Arrays.fill(dist,  Integer.MAX_VALUE); // 가장 오래 걸리는 걸 찾는 거니까 -1로 초기화인줄 알았는데 맥스값으로.
        dist[start] = 0; // 시작점 거리 = 0
        
        // int[] 배열의 두 번째 값(a[1])을 기준으로 오름차순 정렬. / 최소 비용을 가진 노드를 빠르게 선택
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        /*
          X: 현재 정점 번호 (시작점을 지정)
          0: 시작점에서 현재 정점까지의 누적 비용(가중치)
        */
        pq.add(new int[]{start, 0});  

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curVertex = cur[0];
            int curWeight = cur[1];
        
            if(curWeight > dist[curVertex]) continue; // 이미 최적화된 거리보다 크면 무시
            
            for(int[] edge : graph.getOrDefault(curVertex, Collections.emptyList())){
                int nextVertex = edge[0];
                int nextWeight = edge[1];

                /*
                    curWeight: 현재 정점까지의 최단거리.
                    nextWeight: 현재 정점에서 다음 정점까지의 거리. 
                    조건이 참이면, 최단 거리를 갱신.
                    알고리즘 종료 시 dist 배열에는 시작점에서 모든 정점까지의 최단 거리거 저장됨. 
                    dist[nextVertex]: 기존의 최단거
                */
                if(curWeight + nextWeight < dist[nextVertex]){
                    dist[nextVertex] = curWeight + nextWeight; //weight를 vertex에 추가? 
                    pq.add(new int[]{nextVertex, dist[nextVertex]});
                }
            }
        }
        return dist;
    }
    static Map<Integer, List<int[]>> reverseGraph(Map<Integer, List<int[]>> graph, int N){ // 기존 그래프는 왜 가져오는거지?
        Map<Integer, List<int[]>> reversedGraph = new HashMap<>();

        for(int i = 1; i <= N; i++){ // 왜 1부터시작하고, i는 N을 포함하는지?
            reversedGraph.put(i, new ArrayList<>());   
        }

        for(int u : graph.keySet()){ // 키 값을 돌면서
            for(int[] edge : graph.get(u)){ // 간선을 찾는 건가?
                int v = edge[0];
                int cost = edge[1];
                reversedGraph.get(v).add(new int[]{u, cost}); // 간선에 정점을 추가? 
            }
        }

        return reversedGraph;
    }
}


