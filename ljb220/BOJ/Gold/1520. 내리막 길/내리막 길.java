import java.io.*;

public class Main {
    public static int[][] arr = new int[502][502];
    public static int[][] dp =  new int[502][502];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        for (int i = 1; i <= M; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(s[j - 1]);
            }
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        dp[1][1] = 1;
        bw.write(dpfunc(M, N) + "\n");
        bw.flush();
    }

    public static int dpfunc(int x, int y) {
        if (dp[x][y] != -1) return dp[x][y];
        int count = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (arr[nx][ny] > arr[x][y]) count += dpfunc(nx, ny);
        }
        return dp[x][y] = count;
    }
}
