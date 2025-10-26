import java.io.*;
import java.util.*;

public class Main {
    static class Top {
        int index;
        int height;
        Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] top = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Top> stack = new Stack<>();
        stack.push(new Top(-1, Integer.MAX_VALUE));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && top[i] > stack.peek().height) {
                stack.pop();
            }
            list.add(stack.peek().index + 1);
            stack.push(new Top(i, top[i]));
        }
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + " ");
        }
        bw.flush();
    }
}
