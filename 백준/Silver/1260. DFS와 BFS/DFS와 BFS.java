import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
        static Map<Integer, List<Integer>> graph;
        static boolean[] visited;
        static int N, M, V;
        static BufferedReader br;
        static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] node = br.readLine().split(" ");
        N = Integer.parseInt(node[0]);
        M = Integer.parseInt(node[1]);
        V = Integer.parseInt(node[2]);


        graph = new HashMap<>();
        for(int i = 1; i <= N; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            String[] edge = br.readLine().split(" ");
            int edge1 = Integer.parseInt(edge[0]);
            int edge2 = Integer.parseInt(edge[1]);
            graph.get(edge1).add(edge2);
            graph.get(edge2).add(edge1);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        
        visited = new boolean[N + 1];
        dfs(V);

        bw.write("\n");
        
        Arrays.fill(visited, false);
        bfs(V);
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start) throws IOException {
        visited[start] = true;
        bw.write(start+ " ");

        for(int neighbor : graph.get(start)){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }

    public static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            bw.write(cur + " ");
            
            for(int neighbor : graph.get(cur)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
}