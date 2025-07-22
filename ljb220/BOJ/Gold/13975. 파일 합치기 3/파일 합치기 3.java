import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int j = 0; j < K; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long sum = 0;
            while (!pq.isEmpty()) {
                long a = pq.poll();
                if (!pq.isEmpty()) {
                    a += pq.poll();
                    sum += a;
                    pq.offer(a);
                }
                else break;
            }
            bw.write(sum + "\n");
        }
        bw.flush();
    }
}
