import java.util.*;
import java.io.*;

public class Main {
    public static class Vertex {
        int to;
        int weight;
        Vertex(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        List<List<Vertex>> vertices = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            vertices.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            vertices.get(from).add(new Vertex(to, weight));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        pq.offer(new Edge(start, 0));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int u = e.to;
            int w = e.weight;
            if (dist[u] < w) continue;
            for (Vertex v : vertices.get(u)) {
                if (dist[v.to] > dist[u] + v.weight) {
                    dist[v.to] = dist[u] + v.weight;
                    pq.offer(new Edge(v.to, dist[v.to]));
                }
            }
        }
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(dist[i] + "\n");
        }
        bw.flush();
    }
}
