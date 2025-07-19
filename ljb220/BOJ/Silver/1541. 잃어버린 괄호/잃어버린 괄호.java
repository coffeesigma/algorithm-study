import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int sum = 0;
        int isPlus = 1;
        String[] strs = str.split("[+\\-]");
        String[] operators = str.split("[0-9]+");
        int[] arr = new int[strs.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        sum += arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (operators[i].equals("-")) isPlus = -1;
            sum += isPlus * arr[i];
        }
        bw.write(sum + "\n");
        bw.flush();
    }
}
