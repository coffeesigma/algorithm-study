import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                if (i == j) dist[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int inum = Integer.parseInt(st.nextToken()) - 1;
            int jnum = Integer.parseInt(st.nextToken()) - 1;
            dist[inum][jnum] = Math.min(Integer.parseInt(st.nextToken()), dist[inum][jnum]);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) bw.write("0 ");
                else bw.write(dist[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
