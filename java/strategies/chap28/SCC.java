package strategies.chap28;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SCC {

  List<List<Integer>> adj;
  // 각 정점의 컴포넌트 번호
  List<Integer> sccId;
  // 각 정점의 발견 순서
  List<Integer> discovered;
  // 정점의 번호를 담는 스택
  Stack<Integer> st;
  int sccCounter, vertexCounter;

  // here을 루트로 하는 서브트리에서 역방향 간선이나 교차 간선을 통해 갈 수 있는 최소 발견 순서 반환
  // 이미 SCC로 묶인 정점으로 연결된 교차 간선은 무시한다.
  private int scc(int here) {
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
        if(t == here) break;
      }
      ++sccCounter;
    }
    return ret;
  }

  public List<Integer> tarjanSCC(){
    sccId = new ArrayList<>();
    discovered = new ArrayList<>();
    for(int i = 0; i < adj.size(); i++){
      sccId.add(-1);
      discovered.add(-1);
    }
    sccCounter = vertexCounter = 0;
    for(int i = 0; i < adj.size(); i++)
      if(discovered.get(i) == -1)
        scc(i);

    return sccId;
  }
}
