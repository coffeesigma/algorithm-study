import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class BackPack {
        int weight;
        int value;
        BackPack(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<BackPack> backPacks = new ArrayList<>();
        int[][] dp = new int[101][100001];

        backPacks.add(new BackPack(0, 0));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            backPacks.add(new BackPack(weight, value));
        }
        for (int i = 1; i <= n; i++) {
            BackPack backPack = backPacks.get(i);
            for (int j = 1; j <= k; j++) {
                if (j < backPack.weight) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - backPack.weight] + backPack.value);
            }
        }
        bw.write(dp[n][k] + "\n");
        bw.flush();
    }
}
