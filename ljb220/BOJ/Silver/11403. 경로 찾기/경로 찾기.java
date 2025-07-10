import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dp = new int[102][102];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) dp[i][j] = 1;
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dp[i][j] == 1) continue;
                    if (dp[i][k] == 1 && dp[k][j] == 1) dp[i][j] = 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(dp[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
