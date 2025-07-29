import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String answer = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        int slen = s.length();
        int anslen = answer.length();
        for (int i = 0; i < slen; i++) {
            map.put(s.charAt(i), i + 1);
        }
        int tri = 0;
        for (int i = 0; i < anslen; i++) {
            tri = ((tri * slen) +  map.get(answer.charAt(i))) % 900528;
        }
        bw.write(tri + "\n");
        bw.flush();
    }
}
