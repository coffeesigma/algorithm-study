import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        List<String> files = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String file = br.readLine();
            int ismatch = 1;
            if (pattern.length() - 1 > file.length()) {
                bw.write("NE\n");
                continue;
            }
            int pindex = 0;
            int findex = 0;
            while (pattern.charAt(pindex) != '*') {
                if (pattern.charAt(pindex) != file.charAt(findex)) ismatch = 0;
                pindex++;
                findex++;
            }
            pindex = pattern.length() - 1;
            findex = file.length() - 1;
            while (pattern.charAt(pindex) != '*') {
                if (pattern.charAt(pindex) != file.charAt(findex)) ismatch = 0;
                pindex--;
                findex--;
            }
            if (ismatch == 0) {
                bw.write("NE\n");
            }
            else {
                bw.write("DA\n");
            }
        }
        bw.flush();
    }
}
