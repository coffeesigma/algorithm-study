import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr;
    public static int count = 0;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dfs(0);
        bw.write(count + "\n");
        bw.flush();
    }

    public static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            int isValid = 1;
            for (int j = 0; j < depth; j++) {
                if (arr[j] == i || arr[j] == i - depth + j || arr[j] == i + depth - j) {
                    isValid = 0;
                    break;
                }
            }
            if (isValid == 1) dfs(depth + 1);
        }
        arr[depth] = 0;
    }
}
