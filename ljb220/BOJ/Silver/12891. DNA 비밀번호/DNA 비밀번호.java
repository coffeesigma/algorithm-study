import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        Map<Character, Integer> map = Map.of('A', 0, 'C', 1, 'G', 2, 'T', 3);
        int[] limit = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[4];
        int answer = 0;
        int i = 0;
        for (; i < P; i++) {
            count[map.get(s.charAt(i))] += 1;
        }
        int ok = 1;
        for (int j = 0; j <4; j++) {
            if (count[j] < limit[j]) {
                ok = 0;
                break;
            }
        }
        answer = ok;
        for (; i < S; i++) {
            count[map.get(s.charAt(i - P))] -= 1;
            count[map.get(s.charAt(i))] += 1;
            int isok = 1;
            for (int j = 0; j <4; j++) {
                if (count[j] < limit[j]) {
                    isok = 0;
                    break;
                }
            }
            answer += isok;
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
