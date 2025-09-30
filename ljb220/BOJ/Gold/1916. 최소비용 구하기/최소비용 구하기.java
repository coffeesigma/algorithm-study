import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int dest;
        int dist;
        Node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            ArrayList<Node> temp = new ArrayList<>();
            list.add(temp);
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(dest, dist));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.dist));
        int[] dists = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            if (i != start) {
                dists[i] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.dist > dists[node.dest]) continue;
            ArrayList<Node> temp = list.get(node.dest);
            for (int i = 0; i < temp.size(); i++) {
                if (node.dist + temp.get(i).dist < dists[temp.get(i).dest]) {
                    dists[temp.get(i).dest] = node.dist + temp.get(i).dist;
                    pq.add(new Node(temp.get(i).dest, node.dist + temp.get(i).dist));
                }
            }
        }
        bw.write(dists[dest] + "\n");
        bw.flush();
    }
}
