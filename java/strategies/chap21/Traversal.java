package strategies.chap21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Traversal {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    int C = Integer.parseInt(bufferedReader.readLine());
    while (C-- > 0) {
      int N = Integer.parseInt(bufferedReader.readLine());
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      List<Integer> preOrder = new ArrayList<>();
      List<Integer> inOrder = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        preOrder.add(Integer.parseInt(stringTokenizer.nextToken()));
      }

      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      for (int i = 0; i < N; i++) {
        inOrder.add(Integer.parseInt(stringTokenizer.nextToken()));
      }

      changeOrder(preOrder, inOrder);
    }

  }

  private static void changeOrder(List<Integer> preOrder, List<Integer> inOrder) {
    int N = preOrder.size();
    if (preOrder.isEmpty()) {
      return;
    }

    int root = preOrder.get(0);

    int L = inOrder.indexOf(root);
    int R = N - 1 - L;

    changeOrder(slice(preOrder, 1, L + 1), slice(inOrder, 0, L));
    changeOrder(slice(preOrder, L + 1, N), slice(inOrder, L + 1, N));

    System.out.print(root + " ");
  }

  private static List<Integer> slice(List<Integer> tree, int start, int end) {
    return tree.subList(start, end);
  }

}