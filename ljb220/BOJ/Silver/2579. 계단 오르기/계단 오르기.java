import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        int[] stairs = new int[10001];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        for (int i = 3; i <= n; i++) {
            int max = 0;
            max = Math.max(dp[i - 2], max);
            max = Math.max(dp[i - 3] + stairs[i - 1], max);
            dp[i] = max + stairs[i];
        }
        bw.write(dp[n] + "\n");
        bw.flush();
    }
}
