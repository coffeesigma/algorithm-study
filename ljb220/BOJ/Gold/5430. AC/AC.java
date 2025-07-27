import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new LinkedList<>();
            String method = br.readLine();
            int dir = 1;
            int isError = 0;
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().replace("[", "").replace("]", "").split(",");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(s[j]);
                deque.add(num);
            }
            for (int j = 0; j < method.length(); j++) {
                if (method.charAt(j) == 'R') dir *= -1;
                else if (method.charAt(j) == 'D') {
                    if (deque.isEmpty()) {
                        isError = 1;
                        break;
                    }
                    if (dir == 1) deque.removeFirst();
                    else deque.removeLast();
                }
            }
            if (isError == 1) bw.write("error");
            else {
                bw.write("[");
                if (dir == 1) {
                    while (!deque.isEmpty()) {
                        bw.write(deque.pollFirst() + "");
                        if (deque.isEmpty()) break;
                        bw.write(",");
                    }
                }
                else {
                    while (!deque.isEmpty()) {
                        bw.write(deque.pollLast() + "");
                        if (deque.isEmpty()) break;
                        bw.write(",");
                    }
                }
                bw.write("]");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
