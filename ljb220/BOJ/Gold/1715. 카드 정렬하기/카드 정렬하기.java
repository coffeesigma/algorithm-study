import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        long sum = 0;
        while (!pq.isEmpty()) {
            int A = pq.poll();
            if (pq.isEmpty()) break;
            int B = pq.poll();
            sum += A + B;
            pq.offer(A + B);
        }
        bw.write(sum + "\n");
        bw.flush();
    }
}
