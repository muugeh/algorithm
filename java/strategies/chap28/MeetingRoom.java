package strategies.chap28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MeetingRoom {

  private static List<List<Integer>> adj = new ArrayList<>();

  static class Pair implements Comparable<Pair> {
    int start;
    int end;

    public Pair(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
      if(this.start > o.start) return 1;
      else if(this.start < o.start) return -1;
      else return this.end >= o.end ? 1 : -1;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      int n = Integer.parseInt(br.readLine());
      List<Pair> meetings = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
          int start = Integer.parseInt(st.nextToken());
          int end = Integer.parseInt(st.nextToken());
          meetings.add(new Pair(start, end));
        }
      }
      st = new Stack<>();
      makeGraph(meetings);
      System.out.println(solve2SAT());
    }
  }

  private static boolean disjoint(Pair a, Pair b) {
    return a.end <= b.start || b.end <= a.start;
  }

  private static void makeGraph(List<Pair> meetings) {
    int vars = meetings.size();
    adj = new ArrayList<>(vars * 2);
    for (int i = 0; i < vars * 2; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < vars; i += 2) {
      int j = i + 1;
      adj.get(i * 2 + 1).add(j * 2);
      adj.get(j * 2 + 1).add(i * 2);
    }
    for (int i = 0; i < vars; i++)
      for (int j = 0; j < i; j++) {
        if (!disjoint(meetings.get(i), meetings.get(j))) {
          adj.get(i * 2).add(j * 2 + 1);
          adj.get(j * 2).add(i * 2 + 1);
        }
      }
  }

  private static List<Integer> solve2SAT() {
    int n = adj.size();
    List<Integer> label = tarjanSCC();
    for (int i = 0; i < 2 * n; i += 2)
      if (label.get(i).equals(label.get(i + 1)))
        return new ArrayList<>();

    List<Integer> value = new ArrayList<>(2 * n);
    for (int i = 0; i < 2 * n; i++)
      value.add(-1);

    List<Pair> order = new ArrayList<>();
    for(int i = 0; i < 2*n; i++)
      order.add(new Pair(-label.get(i), i));
    Collections.sort(order);
    for(int i = 0; i < 2 * n; i++){
      int vertex = order.get(i).end;
      int variable = vertex / 2;
      int isFalse = vertex % 2;
      if(value.get(variable) != -1) continue;
      value.set(variable, isFalse);
    }
    return value;
  }

  private static List<Integer> sccId;
  // 각 정점의 발견 순서
  private static List<Integer> discovered;
  // 정점의 번호를 담는 스택
  private static Stack<Integer> st;
  private static int sccCounter, vertexCounter;

  // here을 루트로 하는 서브트리에서 역방향 간선이나 교차 간선을 통해 갈 수 있는 최소 발견 순서 반환
  // 이미 SCC로 묶인 정점으로 연결된 교차 간선은 무시한다.
  private static int scc(int here) {
    int ret = discovered.set(here, vertexCounter++);
    st.push(here);
    for (int i = 0; i < adj.get(here).size(); i++) {
      int there = adj.get(here).get(i);
      // (here, there)가 트리 간선
      if (discovered.get(there) == -1)
        ret = Math.min(ret, scc(there));
        // there가 무시해야 하는 교차 간선이 아니라면
      else if (sccId.get(there) == -1)
        ret = Math.min(ret, discovered.get(there));
    }

    // here에서 부모로 올라가는 간선을 끊어야 할지 확인한다.
    if (ret == discovered.get(here)) {
      // here을 루트로 하는 서브트리에 남아 있는 정점들을 전부 하나의 컴포넌트로 묶는다.
      while (true) {
        int t = st.peek();
        st.pop();
        sccId.set(t, sccCounter);
        if (t == here) break;
      }
      ++sccCounter;
    }
    return ret;
  }

  public static List<Integer> tarjanSCC() {
    sccId = new ArrayList<>();
    discovered = new ArrayList<>();
    for (int i = 0; i < adj.size(); i++) {
      sccId.add(-1);
      discovered.add(-1);
    }
    sccCounter = vertexCounter = 0;
    for (int i = 0; i < adj.size(); i++)
      if (discovered.get(i) == -1)
        scc(i);

    return sccId;
  }

}