import java.io.*;
import java.util.*;

public class Main {
    public static class Jewel {
        int mass;
        int value;
        public Jewel(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Jewel> jewels = new PriorityQueue<>(Comparator.comparing(j -> j.mass));
        LinkedList<Integer> bags = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(M, V));
        }
        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        bags.sort(Comparator.naturalOrder());
        long value = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer m : bags) {
            while (!jewels.isEmpty()) {
                Jewel j = jewels.peek();
                if (j.mass <= m) {
                    jewels.poll();
                    pq.offer(j.value);
                }
                else break;
            }
            if (!pq.isEmpty()) {
                value += pq.poll();
            }
        }

        bw.write(value + "\n");
        bw.flush();
    }
}
