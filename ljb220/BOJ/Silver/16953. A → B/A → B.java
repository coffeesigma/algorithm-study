import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 0;
        while (B > 0) {
            if (A == B) break;
            int nowB;
            if (B % 2 == 0) nowB = B / 2;
            else if (B % 10 == 1) nowB = B / 10;
            else break;
            count++;
            B = nowB;
        }
        if (A == B) bw.write((count + 1) + "\n");
        else bw.write( "-1\n");
        bw.flush();
    }
}
