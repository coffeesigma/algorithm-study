import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        List<String> letters = new ArrayList<>();
        List<HashMap<Character, Integer>> dictMaps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String w = br.readLine();
            letters.add(w);
            dictMaps.add(toMap(w));
        }

        int L = str.length();
        int[] dp = new int[L + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= L; i++) {
            int bestAll = Integer.MAX_VALUE;

            for (int lastDp = i - 1; lastDp >= 0; lastDp--) {
                if (dp[lastDp] == -1) continue;

                String substr = str.substring(lastDp, i);
                HashMap<Character, Integer> subMap = toMap(substr);

                int bestSeg = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    String w = letters.get(j);
                    if (dictMaps.get(j).equals(subMap)) {
                        int cost = calculateCost(substr, w);
                        if (cost < bestSeg) bestSeg = cost;
                    }
                }

                if (bestSeg != Integer.MAX_VALUE) {
                    int cand = dp[lastDp] + bestSeg;
                    if (cand < bestAll) bestAll = cand;
                }
            }
            dp[i] = (bestAll == Integer.MAX_VALUE) ? -1 : bestAll;
        }

        bw.write(dp[L] + "\n");
        bw.flush();
    }

    public static HashMap<Character, Integer> toMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static int calculateCost(String a, String b) {
        int cost = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cost++;
        }
        return cost;
    }
}
