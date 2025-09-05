import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int maxHeight = 0;
        int[][] arrCopy = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arrCopy[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arrCopy[i][j]);
            }
        }
        int max = 0;
        for (int i = 0; i <= maxHeight; i++) {
            int sum = 0;
            arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                arr[j] = Arrays.copyOf(arrCopy[j], n);
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sum += dfs(j, k, i);
                }
            }
            max = Math.max(max, sum);
        }
        bw.write(max + "\n");
        bw.flush();
    }

    public static int dfs(int x, int y, int max) {
        if (x >= n || y >= n || x < 0 || y < 0) return 0;
        if (arr[x][y] <= max) return 0;
        arr[x][y] = max;
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            dfs(nx, ny, max);
        }
        return 1;
    }
}
