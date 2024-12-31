import java.util.*;
import java.lang.*;
import java.io.*;

class Edge {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Main {
    static int INF = Integer.MAX_VALUE;
    static Map<Integer, List<Edge>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, w));
        }

        // 출발지와 도착지 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘 실행
        Result result = dijkstra(start, end);

        // 출력
        System.out.println(result.minCost);
        System.out.println(result.path.size());
        for (int city : result.path) {
            System.out.print(city + " ");
        }
    }

    public static Result dijkstra(int start, int end) {
        int[] dist = new int[graph.size() + 1];
        int[] parent = new int[graph.size() + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int curVertex = current.to;
            int curCost = current.weight;

            // 현재 비용이 더 크다면 무시
            if (curCost > dist[curVertex]) continue;

            // 간선 탐색
            for (Edge edge : graph.get(curVertex)) {
                int nextVertex = edge.to;
                int nextCost = curCost + edge.weight;

                // 거리 업데이트
                if (nextCost < dist[nextVertex]) {
                    dist[nextVertex] = nextCost;
                    parent[nextVertex] = curVertex; // 부모 업데이트
                    pq.add(new Edge(nextVertex, nextCost));
                }
            }
        }

        // 경로 추적
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        return new Result(dist[end], path);
    }
}

// 최소 비용과 경로를 저장하는 클래스
class Result {
    int minCost;
    List<Integer> path;

    public Result(int minCost, List<Integer> path) {
        this.minCost = minCost;
        this.path = path;
    }
}
