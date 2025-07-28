import java.io.*;
import java.util.*;

public class Main {
    public static class TreeNode implements Comparable<TreeNode> {
        String val;
        int depth;
        List<TreeNode> children;

        public TreeNode(String val, int depth) {
            this.val = val;
            this.depth = depth;
            this.children = new ArrayList<>();
        }

        public TreeNode addChildren(String val) {
            TreeNode node = new TreeNode(val, depth + 1);
            for (TreeNode child : this.children) {
                if (child.compareTo(node) == 0) {
                    return child;
                }
            }
            children.add(node);
            return node;
        }

        @Override
        public int compareTo(TreeNode o) {
            if (this.depth == o.depth) return this.val.compareTo(o.val);
            else return this.depth - o.depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] s;
        TreeNode root = new TreeNode(null, 0);
        for (int i = 0; i < N; i++) {
            TreeNode now = root;
            s = br.readLine().split(" ");
            for  (int j = 1; j < s.length; j++) {
                now = now.addChildren(s[j]);
            }
        }
        printTree(root);
    }

    public static void printTree(TreeNode root) {
        root.children.sort(Comparator.comparing(o -> o.val));
        for (TreeNode node : root.children) {
            for (int i = 1; i < node.depth; i++) System.out.print("--");
            System.out.println(node.val);
            printTree(node);
        }
    }
}
