import java.io.*;
import java.util.*;

public class Main {
    public static class Lecture {
        int start;
        int end;
        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Lecture(start, end));
        }
        list.sort(Comparator.comparingInt(l -> l.start));
        PriorityQueue<Integer> clazz =  new PriorityQueue<>();
        for (Lecture lecture : list) {
            if (clazz.isEmpty() || clazz.peek() > lecture.start) {
                clazz.offer(lecture.end);
            }
            else {
                clazz.poll();
                clazz.offer(lecture.end);
            }
        }
        bw.write(clazz.size() + "\n");
        bw.flush();
    }
}
