import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] xarr = new int[n];
        int[] yarr = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xarr[i] = Integer.parseInt(st.nextToken());
            yarr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(xarr);
        Arrays.sort(yarr);
        int midx = xarr[xarr.length / 2], midy = yarr[yarr.length / 2];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(midx - xarr[i]);
            sum += Math.abs(midy - yarr[i]);
        }
        bw.write(sum + "\n");
        bw.flush();
    }
}
