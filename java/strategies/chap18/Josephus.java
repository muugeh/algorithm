package strategies.chap18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Josephus {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    int c = Integer.parseInt(bufferedReader.readLine());
    while (c-- > 0) {
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int n = Integer.parseInt(stringTokenizer.nextToken());
      int k = Integer.parseInt(stringTokenizer.nextToken());

      // System.out.println(solve(n, k));
      System.out.println(solveByLinkedList(n, k));
    }

  }

  private static String solveByLinkedList(int n, int k) {
    LinkedList<Integer> survivors = new LinkedList<>();
    for (int i = 1; i <= n; ++i) {
      survivors.add(i);
    }
    Iterator<Integer> kill = survivors.iterator();
    kill.next();

    while (n > 2) {
      kill.remove();
      if (!kill.hasNext()) {
        kill = survivors.iterator();
      }
      kill.next();
      --n;

      for (int i = 0; i < k - 1; i++) {
        if (!kill.hasNext()) {
          kill = survivors.iterator();
        }
        kill.next();
      }
    }
    return survivors.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
  }

  private static List<Integer> solve(int n, int k) {
    boolean[] dead = new boolean[n];
    dead[0] = true;
    int lot = 0;
    int count = 0;
    int remains = n - 1;

    while (remains > 2) {
      if (!dead[lot]) {
        if (count == k - 1) {
          count = 0;
          remains--;
          dead[lot] = true;
        } else {
          count++;
        }
      }
      if (++lot == n) {
        lot = 0;
      }
    }

    List<Integer> alive = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!dead[i]) {
        alive.add(i + 1);
      }
    }

    return alive;
  }


}