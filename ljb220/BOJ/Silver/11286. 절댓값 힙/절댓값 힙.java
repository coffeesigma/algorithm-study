import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing((Integer n) -> Math.abs(n)).thenComparing((Integer n) -> n));
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (now == 0) {
                if (pq.isEmpty()) bw.write(0 + "\n");
                else bw.write(pq.poll() + "\n");
            }
            else {
                pq.offer(now);
            }
        }
        bw.flush();
    }
}
