import java.io.*;
import java.util.*;

public class Main {
    public static class Vertex {
        int index;
        int cost;
        Vertex(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public static class Edge {
        int to;
        int cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        List<List<Edge>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new Edge(to, cost));
            list.get(to).add(new Edge(from, cost));
        }
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.cost));
        pq.offer(new Vertex(1, 0));
        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            if (v.cost > dist[v.index]) continue;
            for (Edge e : list.get(v.index)) {
                if (dist[e.to] > dist[v.index] + e.cost) {
                    dist[e.to] = dist[v.index] + e.cost;
                    pq.offer(new Vertex(e.to, dist[e.to]));
                }
            }
        }
        bw.write(dist[N] + "\n");
        bw.flush();
    }
}
