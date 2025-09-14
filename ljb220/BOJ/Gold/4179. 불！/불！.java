import java.io.*;
import java.util.*;

public class Main {
    public static class Point {
        int x, y;
        String status;
        int time;
        public Point(int x, int y, String status, int time) {
            this.x = x;
            this.y = y;
            this.status = status;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[][] arr = new String[R][C];
        Queue<Point> q = new LinkedList<>();
        Point J = null;
        for (int i = 0; i < R; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                arr[i][j] = str[j];
                if (arr[i][j].equals("F")) q.offer(new Point(i, j, "F", 0));
                if (arr[i][j].equals("J")) J = new Point(i, j, "J", 0);
            }
        }
        q.offer(J);
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int escape = 0;
        int escapetime = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.status.equals("J")) {
                for (int[] dir : dirs) {
                    int nx = p.x + dir[0], ny = p.y + dir[1];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        escape = 1;
                        escapetime = p.time + 1;
                        break;
                    }
                    if (arr[nx][ny].equals("F") || arr[nx][ny].equals("J") || arr[nx][ny].equals("#")) continue;
                    else {
                        arr[nx][ny] = "J";
                        q.offer(new Point(nx, ny, "J", p.time + 1));
                    }
                }
            }
            if (p.status.equals("F")) {
                for (int[] dir : dirs) {
                    int nx = p.x + dir[0], ny = p.y + dir[1];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (arr[nx][ny].equals("F") || arr[nx][ny].equals("#")) continue;
                    else {
                        arr[nx][ny] = "F";
                        q.offer(new Point(nx, ny, "F", p.time + 1));
                    }
                }
            }
            if (escape == 1) break;
        }
        if (escape == 0) bw.write("IMPOSSIBLE\n");
        else bw.write(escapetime + "\n");
        bw.flush();
    }
}
