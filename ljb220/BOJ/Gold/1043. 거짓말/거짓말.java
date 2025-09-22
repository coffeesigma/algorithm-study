import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        Set<Integer> liyers = new HashSet<>();
        for (int i = 0; i < K; i++) {
            liyers.add(Integer.parseInt(st.nextToken()));
        }
        List<Set<Integer>> party = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < K; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            party.add(set);
        }
        Queue<Integer> q = new LinkedList<>();
        for (Integer i: liyers) {
            q.offer(i);
        }
        int[] visited = new int[M];
        while (!q.isEmpty()) {
            int num = q.poll();
            for (int i = 0; i < M; i++) {
                Set<Integer> set = party.get(i);
                if (visited[i] == 1) continue;
                if (set.contains(num)) {
                    visited[i] = 1;
                    for (Integer man: set) {
                        if (!liyers.contains(man)) {
                            q.offer(man);
                            liyers.add(man);
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (visited[i] == 0) count++;
        }
        bw.write(count + "\n");
        bw.flush();
    }
}
