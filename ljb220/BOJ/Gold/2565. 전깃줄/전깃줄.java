import java.io.*;
import java.util.*;

public class Main {
    static class Line {
        int A;
        int B;
        Line(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Line> list = new ArrayList<>();
        int[] dp = new int[501];
        list.add(new Line(0, 0));
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.add(new Line(A, B));
        }
        list.sort(Comparator.comparingInt(line -> line.A));
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (max < dp[j] && list.get(j).B < list.get(i).B) max = dp[j];
            }
            dp[i] = max + 1;
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        bw.write((n - max) + "\n");
        bw.flush();
    }
}
