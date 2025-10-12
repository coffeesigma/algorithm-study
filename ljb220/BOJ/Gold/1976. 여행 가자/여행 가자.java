import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int isConnect = Integer.parseInt(st.nextToken());
                if (j < i && isConnect == 1) {
                    union(i + 1, j + 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int isAble = 1;
        for (int i = 1; i < M; i++) {
            if (findRoot(list.get(i - 1)) != findRoot(list.get(i))) {
                isAble = 0;
                break;
            }
        }
        if (isAble == 1) bw.write("YES\n");
        else bw.write("NO\n");
        bw.flush();
    }

    public static int findRoot(int find) {
        while (arr[find] != find) {
            find = arr[find];
        }
        return find;
    }

    public static void union(int a, int b) {
        int ra = findRoot(a);
        int rb = findRoot(b);
        if (ra == rb) return;
        int root = Math.min(ra, rb);
        int other = (root == ra) ? rb : ra;
        arr[other] = root;
    }
}
