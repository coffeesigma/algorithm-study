import java.io.*;
import java.util.*;

public class Main {
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M + 2][N + 2];
        for (int i = 0; i < M + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                if (i == 0 || j == 0 || i == N - 1 || j == M - 1) arr[i][j] = -1;
            }
        }
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    list.add(0);
                    queue.add(list);
                }
            }
        }
        int nowday = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek().get(2) == nowday) {
                ArrayList<Integer> list = queue.poll();
                int x = list.get(0);
                int y = list.get(1);
                int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx > M || ny < 0 || ny > N) continue;
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.add(nx);
                        newList.add(ny);
                        newList.add(nowday + 1);
                        queue.add(newList);
                    }
                }
            }
            if (queue.isEmpty()) break;
            nowday++;
        }
        int isblank = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 0) {
                    isblank = 1;
                    break;
                }
            }
        }
        if (isblank == 1) bw.write("-1\n");
        else bw.write(nowday + "\n");
        bw.flush();
    }
}
