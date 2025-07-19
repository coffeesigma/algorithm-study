import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] orders = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> line = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            line.add(orders[i], i + 1);
        }
        for (int l : line) {
            bw.write(l + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
