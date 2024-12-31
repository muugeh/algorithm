package strategies.chap25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EditorWars {

  static BiPartitionUnionFind union;
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      union = new BiPartitionUnionFind(n);
      boolean ok = true;

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        boolean ack = st.nextToken()
                        .equals("ACK");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (ack) {
          ok = union.ack(a, b);
        } else {
          ok = union.dis(a, b);
        }
        if (!ok) {
          bw.write("CONTRADICTION AT " + (i+1) + "\n");
          bw.flush();
          break;
        }
      }
      if (ok) {
        bw.write("MAX PARTY IS " + maxParty(union) +"\n");
        bw.flush();
      }
    }
  }

  private static int maxParty(BiPartitionUnionFind buf) {
    int ret = 0;
    for (int node = 0; node < n; node++) {
      if (buf.parent.get(node) == node) {
        int enemy = buf.enemy.get(node);
        if (enemy > node) {
          continue;
        }
        int mySize = buf.size.get(node);
        int enemySize = (enemy == -1 ? 0 : buf.size.get(enemy));
        ret += Math.max(mySize, enemySize);
      }
    }
    return ret;
  }


  static class BiPartitionUnionFind {

    List<Integer> parent;
    List<Integer> rank;
    List<Integer> enemy;
    List<Integer> size;

    public BiPartitionUnionFind(int n) {
      parent = new ArrayList<>(n);
      rank = new ArrayList<>(n);
      enemy = new ArrayList<>(n);
      size = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        parent.add(i);
        rank.add(0);
        enemy.add(-1);
        size.add(1);
      }
    }

    public int find(int u) {
      if (u == parent.get(u)) {
        return u;
      }
      parent.set(u, find(parent.get(u)));
      return parent.get(u);
    }

    public int merge(int u, int v) {
      if (u == -1 || v == -1) {
        return Math.max(u, v);
      }
      u = find(u);
      v = find(v);
      if (u == v) {
        return u;
      }

      if (rank.get(u) > rank.get(v)) {
        v = swap(u, u = v);
      }
      if (rank.get(u)
              .equals(rank.get(v))) {
        rank.set(v, rank.get(v) + 1);
      }
      parent.set(u, v);
      size.set(v, size.get(v) + size.get(u));
      return v;
    }

    public boolean dis(int u, int v) {
      u = find(u);
      v = find(v);
      if (u == v) {
        return false;
      }
      int a = merge(u, enemy.get(v));
      int b = merge(v, enemy.get(u));
      enemy.set(a, b);
      enemy.set(b, a);
      return true;
    }

    public boolean ack(int u, int v) {
      u = find(u);
      v = find(v);
      if (enemy.get(u) == v) {
        return false;
      }
      int a = merge(u, v);
      int b = merge(enemy.get(u), enemy.get(v));
      enemy.set(a, b);
      if (b != -1) {
        enemy.set(b, a);
      }
      return true;
    }

    private int swap(int a, int b) {
      return a;
    }
  }
}