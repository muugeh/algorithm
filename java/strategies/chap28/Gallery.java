package strategies.chap28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gallery {

  private static int g;
  private static List<List<Integer>> adj = new ArrayList<>();
  private static List<Boolean> visited = new ArrayList<>();
  private static final int UNWATCHED = 0;
  private static final int WATCHED = 1;
  private static final int INSTALLED = 2;
  // 지금까지 설치한 카메라의 총 수
  private static int installed;

  private static int dfs(int here) {
    visited.set(here, true);
    boolean[] children = new boolean[3];
    for (int i = 0; i < adj.get(here).size(); i++) {
      int there = adj.get(here).get(i);
      if (!visited. get(there))
        children[dfs(there)] = true;
    }
    // 자손 노드 중 감시되지 않은 노드가 있는 경우 카메라를 설치합니다.
    if (children[UNWATCHED]) {
      ++installed;
      return INSTALLED;
    }
    // 자손 노드 중 카메라가 설치된 노드가 있을 경우 설치할 필요가 없다.
    if (children[INSTALLED])
      return WATCHED;
    return UNWATCHED;
  }

  private static int installCamera() {
    installed = 0;
    visited = new ArrayList<>();
    for (int i = 0; i < g; i++) {
      visited.add(false);
    }
    for (int u = 0; u < g; u++)
      if (!visited.get(u) && dfs(u) == UNWATCHED)
        ++installed;

    return installed;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      g = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      adj.clear();
      for(int i = 0; i < g; i++)
        adj.add(new ArrayList<>());
      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        adj.get(a).add(b);
        adj.get(b).add(a);
      }
      System.out.println(installCamera());
    }
  }
}
