import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int[] cost = new int[N + 1];
            int[] dp = new int[N + 1];
            Arrays.fill(dp, -1);
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list.get(end).add(start);
            }
            int W = Integer.parseInt(br.readLine());
            bw.write(dpf(dp, cost, list, W) + "\n");
        }
        bw.flush();
    }

    public static int dpf(int[] dp, int[] cost, ArrayList<ArrayList<Integer>> list, int now) {
        if (dp[now] != -1) return dp[now];
        if (list.get(now).size() == 0) {
            dp[now] = cost[now];
        }
        int max = 0;
        for (int i : list.get(now)) {
            max = Math.max(max, dpf(dp, cost, list, i));
        }
        dp[now] = max + cost[now];
        return dp[now];
    }
}
