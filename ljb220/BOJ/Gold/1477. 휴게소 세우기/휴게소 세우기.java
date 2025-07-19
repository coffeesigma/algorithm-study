import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        list.add(0);
        list.add(L);
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.naturalOrder());
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            list1.add(list.get(i) - list.get(i - 1));
        }

        int start = 1;
        int end = L;
        int answer = 0;
        while (start <= end) {
            int count = 0;
            int mid = (start + end) / 2;
            for (int l :  list1) {
                if (l % mid == 0) count += l / mid - 1;
                else count += l / mid;
            }
//            bw.write("count: " + count + "\n");
//            bw.write("mid: " + mid + "\n");
            if (count > M) start = mid + 1;
            else {
                answer = mid;
                end = mid - 1;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
