import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Edge implements Comparable<Edge> {
    int vertex;
    int weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class Main {
    static int N, E; 
    static final int INF = Integer.MAX_VALUE;
    static Map<Integer, List<Edge>> graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        if (N < 2 || E < 0) {
            System.out.println("-1");
            return;
        }

        graph = initializeGraph(N);

        // 간선 입력 
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w)); // 무방향
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        if (v1 < 1 || v1 > N || v2 < 1 || v2 > N) {
            System.out.println("-1");
            return;
        }

        // 각각의 최단 경로를 계산
        int[] fromStart = dijkstra(1);
        int[] fromV1 = dijkstra(v1);
        int[] fromV2 = dijkstra(v2);

        // 가능한 최단 경로 중 최소값 출력
        int route1 = calculateRoute(fromStart, fromV1, fromV2, v1, v2);
        int route2 = calculateRoute(fromStart, fromV2, fromV1, v2, v1);

        int result = Math.min(route1, route2);
        System.out.println(result >= INF ? -1 : result);
    }
    
    private static Map<Integer, List<Edge>> initializeGraph(int nodes) {
        Map<Integer, List<Edge>> graph = new HashMap<>(nodes);
        for (int i = 1; i <= nodes; i++) {
            graph.put(i, new ArrayList<>());
        }
        return graph;
    }
    
    private static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0; 
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curVertex = cur.vertex;
            int curCost = cur.weight;

            if (curCost > dist[curVertex]) continue; 

            for (Edge edge : graph.getOrDefault(curVertex, Collections.emptyList())) {
                int nextVertex = edge.vertex;
                int nextCost = curCost + edge.weight;

                if (nextCost < dist[nextVertex]) {
                    dist[nextVertex] = nextCost; 
                    pq.add(new Edge(nextVertex, nextCost));
                }
            }
        }
        return dist;
    }
    
    private static int calculateRoute(int[] fromStart, int[] fromV1, int[] fromV2, int v1, int v2) {
        if (fromStart[v1] == INF || fromV1[v2] == INF || fromV2[N] == INF) {
            return INF;
        }
        return fromStart[v1] + fromV1[v2] + fromV2[N];
    }
}
