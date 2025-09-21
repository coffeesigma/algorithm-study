import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[T + 1];
        ArrayList<Integer> list = new ArrayList<>();
        arr[0] = 1;
        list.add(0);
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i - 1] == arr[i]) {
                list.set(list.size() - 1, list.get(list.size() - 1) + 1);
            }
            else {
                list.add(1);
            }
        }
        int length = list.size();
        int[][] dp = new int[length + 1][W + 1];
        dp[0][0] = list.get(0);
        for (int i = 2; i < length; i = i + 2) {
            dp[i][0] = dp[i - 2][0] + list.get(i);
        }
        for (int i = 1; i <= W; i++) {
            dp[0][i] = list.get(0);
            if (length > 1) dp[1][i] = dp[0][0] + list.get(1);
        }
        for (int i = 2; i < length; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = Math.max(dp[i - 2][j], dp[i - 1][j - 1]) + list.get(i);
            }
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= W; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        bw.write(max + "\n");
        bw.flush();
    }
}
