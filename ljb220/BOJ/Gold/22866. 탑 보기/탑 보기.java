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
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            while(!stack.isEmpty() && stack.peek().height <= top[i]) {
                stack.pop();
            }
            list.get(i).add(stack.size());
            if (!stack.isEmpty()) {
                list.get(i).add(stack.peek().index);
            }
            stack.push(new Top(i, top[i]));
        }
        stack.clear();
        for (int i = N - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek().height <= top[i]) {
                stack.pop();
            }
            list.get(i).set(0, list.get(i).get(0) + stack.size());
            if (!stack.isEmpty()) {
                if (list.get(i).size() < 2) list.get(i).add(stack.peek().index);
                else if (Math.abs(stack.peek().index - i) < Math.abs(list.get(i).get(1) - i))
                    list.get(i).set(1, stack.peek().index);
            }
            stack.push(new Top(i, top[i]));
        }
        for (int i = 0; i < N; i++) {
            List<Integer> temp = list.get(i);
            bw.write(temp.get(0) + " ");
            if (temp.size() > 1) {
                bw.write((temp.get(1) + 1) + "");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}