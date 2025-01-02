import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Edge implements Comparable<Edge> {
    int vertex, weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
class Pair {
    int u, v; 

    Pair(int u, int v){
        this.u = u; 
        this.v = v; 
    }
    // 이거 꼭 있어야 하는지 의문... 코드가 너무 어려워서
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pair)) return false;
        Pair p = (Pair) obj;
        return this.u == p.u && this.v == p.v;
    }
    // 이거 꼭 있어야 하는지 의문... 코드가 너무 어려워서
    @Override
    public int hashCode() {
        return Objects.hash(u, v);
    }
}
class Main {
    static int N, M, S, D;
    static List<List<Edge>> graph, reverseGraph; // List<Edge> 까지는 알겠는데 [] 뭐지??
    static final int INF = Integer.MAX_VALUE;
    static Set<Pair> isShortestPath;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); //이거 왜 쓴거지?? 

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break; // 예외 처리

            st = new StringTokenizer(br.readLine());
             S = Integer.parseInt(st.nextToken());
             D = Integer.parseInt(st.nextToken());
    
            graph = new ArrayList<>();
            reverseGraph = new ArrayList<>();
            isShortestPath = new HashSet<>();
            
            for(int i = 0; i< N; i++){
                graph.add(new ArrayList<>());
                reverseGraph.add(new ArrayList<>());
            }
    
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                graph.get(u).add(new Edge(v, p));
                reverseGraph.get(v).add(new Edge(u, p)); // 여기엔 u 를 넣는 이유는? 
            }

            int[] dist = dijkstra(S, graph);
            // if (dist[D] == INF) {
            //     sb.append("-1\n");
            //     continue;
            // }
            
            removeShortestPaths(dist);
            int[] almostShortestDist = dijkstra(S,graph);

            // 이어지지 않았다면 -1 반환, 아니라면 그 값을 반환.
            sb.append(almostShortestDist[D] == INF ? "-1\n" : almostShortestDist[D] + "\n");
        }
        System.out.print(sb.toString());
    }


    
    private static int[] dijkstra(int start, List<List<Edge>> graph){
        int[] dist = new int[N]; // N + 1하지 않은 이유는?
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
                                                
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int curVertex = cur.vertex;
            int curWeight = cur.weight;

            if(curWeight > dist[curVertex]) continue;

            for(Edge edge : graph.get(curVertex)){ // getOrDefault 사용하지 않는 이유는?
                // 이게 어떤 코드지? 
                if(isShortestPath.contains(new Pair(curVertex, edge.vertex))) continue;
                
                int nextVertex = edge.vertex;
                int nextWeight = curWeight + edge.weight;

                if(nextWeight < dist[nextVertex]){
                    dist[nextVertex] = nextWeight;
                    pq.add(new Edge(nextVertex, nextWeight));
                }
            }
        }
        return dist;
    }


    
    private static void removeShortestPaths(int[] dist){
        Queue<Integer> q = new LinkedList<>(); // ArrayDeque 가 더 성능지 좋지 않나?
        boolean[] visited = new boolean[N];  // 방문 체크 배열
        q.add(D);
        visited[D] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Edge edge : reverseGraph.get(cur)){
                int prev = edge.vertex;

                if(dist[prev] + edge.weight == dist[cur]){
                    isShortestPath.add(new Pair(prev, cur));

                    if(!visited[prev]){
                        visited[prev] = true;
                        q.add(prev);
                    }
                }
            }
        }
    }






    
}