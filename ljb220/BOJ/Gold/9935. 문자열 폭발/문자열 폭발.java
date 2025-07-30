import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String bomb = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < bomb.length(); i++) {
            map.put(bomb.charAt(i), i + 1);
        }
        List<Character> list = new LinkedList<>();
        List<Character> stackList = new LinkedList<>();
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                list.addAll(stackList);
                stackList.clear();
                list.add(c);
            }
            else {
                if (stackList.isEmpty()) {
                    if (map.get(c) == 1) stackList.add(c);
                    else list.add(c);
                }
                else {
                    if (map.get(c) == 1) stackList.add(c);
                    else {
                        if (map.get(c) == map.get(stackList.get(stackList.size() - 1)) + 1) stackList.add(c);
                        else {
                            list.addAll(stackList);
                            stackList.clear();
                            list.add(c);
                        }
                    }
                }
                int bombLength = bomb.length();
                if (!stackList.isEmpty() && map.get(stackList.get(stackList.size() - 1)) == bombLength) {
                    for (int j = 0; j < bombLength; j++) stackList.remove(stackList.size() - 1);
                }
            }
        }
        if (!stackList.isEmpty()) list.addAll(stackList);
        if (list.isEmpty()) System.out.println("FRULA");
        else {
            for (Character c : list) {
                bw.write(c + "");
            }
            bw.write("\n");
            bw.flush();
        }
    }
}
