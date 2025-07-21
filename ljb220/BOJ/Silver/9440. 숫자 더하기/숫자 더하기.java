import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int zeroCount = 0;
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            for (int i = 0; i < N; i++) {
                int digit = Integer.parseInt(st.nextToken());
                if (digit != 0) pq.offer(digit);
                else zeroCount++;
            }
            int sum = 0;
            sum += pq.poll();
            if (N % 2 == 0) {
                sum += pq.poll();
                for (int i = 0; i < zeroCount; i++) pq.offer(0);
            }
            else {
                sum *= 10;
                sum += pq.poll();
                for (int i = 0; i < zeroCount; i++) pq.offer(0);
                sum += pq.poll();
            }
            while (!pq.isEmpty()) {
                sum *= 10;
                sum += pq.poll();
                sum += pq.poll();
            }
            bw.write(sum + "\n");
        }
        bw.flush();
    }
}
