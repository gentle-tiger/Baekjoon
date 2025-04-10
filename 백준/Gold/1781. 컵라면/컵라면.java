import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());

            if (!map.containsKey(deadline)) {
                map.put(deadline, new ArrayList<>());
            }
            map.get(deadline).add(ramen);
        }

        List<Integer> deadlines = new ArrayList<>(map.keySet());
        Collections.sort(deadlines);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int totalRamen = 0;

        for (int deadline : deadlines) {
            for (int ramen : map.get(deadline)) {
                pq.add(ramen);
                if (pq.size() > deadline) {
                    pq.poll();
                }
            }
        }

        while (!pq.isEmpty()) {
            totalRamen += pq.poll();
        }

        System.out.println(totalRamen);
    }
}
