import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int low = 0;
        int high = Collections.max(list);
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            long wood = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > mid) wood += list.get(i) - mid;
            }
            if (wood >= M) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
