package strategies.chap21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Fortress {


  static int N;
  static int[] x, y, r;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int C = Integer.parseInt(bufferedReader.readLine());
    while (C-- > 0) {
      N = Integer.parseInt(bufferedReader.readLine()
                                         .trim());
      x = new int[N];
      y = new int[N];
      r = new int[N];
      for (int i = 0; i < N; i++) {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()
                                                                            .trim());
        x[i] = Integer.parseInt(stringTokenizer.nextToken());
        y[i] = Integer.parseInt(stringTokenizer.nextToken());
        r[i] = Integer.parseInt(stringTokenizer.nextToken());
      }
      TreeNode treeNode = getTree(0);
      System.out.println(solve(treeNode));
    }
  }

  static int longest;

  static int height(TreeNode root) {
    List<Integer> heights = new ArrayList<>();
    for (int i = 0; i < root.children.size(); i++) {
      heights.add(height(root.children.get(i)));
    }

    if (heights.isEmpty()) {
      return 0;
    }

    Collections.sort(heights);
    if (heights.size() >= 2) {
      longest = Math.max(longest,
                         2 + heights.get(heights.size() - 2) + heights.get(heights.size() - 1));
    }
    return heights.get(heights.size() - 1) + 1;
  }

  static int solve(TreeNode root) {
    longest = 0;
    int h = height(root);
    return Math.max(longest, h);
  }

  static TreeNode getTree(int root) {
    TreeNode ret = new TreeNode();
    for (int ch = 0; ch < N; ch++) {
      if (isChild(root, ch)) {
        ret.children.add(getTree(ch));
      }
    }
    return ret;
  }

  static int sqr(int x){
    return x*x;
  }

  static int sqrtdist(int a, int b) {
    return sqr(y[a] - y[b]) + sqr(x[a] - x[b]);
  }

  static boolean enclose(int a, int b) {
    return r[a] > r[b] && sqrtdist(a, b) < sqr(r[a] - r[b]);
  }

  static boolean isChild(int parent, int child) {
    if (!enclose(parent, child)) {
      return false;
    }
    for (int i = 0; i < N; i++) {
      if (i != parent && i != child && enclose(parent, i) && enclose(i, child)) {
        return false;
      }
    }
    return true;
  }

}

class TreeNode {
  List<TreeNode> children = new ArrayList<>();

  public TreeNode(){

  }
}

