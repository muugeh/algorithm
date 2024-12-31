package strategies.chap25;

import java.util.ArrayList;
import java.util.List;

public class NaiveDisjointSet {
  List<Integer> parent;

  public NaiveDisjointSet(int n){
    parent = new ArrayList<>(n);
    for(int i = 0; i < n; i++)
      parent.add(i);
  }

  public int find(int u){
    if(u == parent.get(u)) return u;
    return find(parent.get(u));
  }

  public void merge(int u, int v){
    u = find(u);
    v = find(v);
    // 트리가 같은 경우 종료
    if(u == v) return;
    parent.set(u, v);
  }
}