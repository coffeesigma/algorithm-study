import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 1;
        if (N == 1 || M == 1) ;
        else if (N <= 2 && M <= 2) ;
        else if (N <= 2 && M < 5) answer = 2;
        else if (N <= 2 && M < 7) answer = 3;
        else if (N <= 2) answer = 4;
        else if (M <= 2) answer = 2;
        else if (M < 5) answer = M;
        else if (M == 5) answer = 4;
        else answer = M - 2;

        bw.write(answer + "\n");
        bw.flush();
    }
}
