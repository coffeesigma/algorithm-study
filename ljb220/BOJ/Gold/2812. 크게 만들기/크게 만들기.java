import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String num = br.readLine();
        int[] numArr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            numArr[i] = num.charAt(i) - '0';
        }
        numArr[N] = 10;
        int digit = numArr[0];
        int decrease = 1;
        for (int i = 1; i <= N; i++) {
            int newDigit = numArr[i];
            if (newDigit <= digit) {
                decrease += 1;
            }
            else {
                int nowDecrease = decrease;
                while (decrease > 0 && K > 0) {
                    if (numArr[i - 1 - nowDecrease + decrease] == -1) nowDecrease++;
                    else if (numArr[i - 1 - nowDecrease + decrease] < newDigit) {
                        numArr[i - 1 - nowDecrease + decrease] = -1;
                        decrease -= 1;
                        K -= 1;
                    }
                    else break;
                }
                decrease += 1;
            }
            digit = newDigit;
        }
        for (int i = 0; i < N; i++) {
            if (numArr[i] != -1) {
                bw.write(numArr[i] + "");
            }
        }
        bw.write("\n");
        bw.flush();
    }
}
