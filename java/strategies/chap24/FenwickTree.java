package strategies.chap24;

import java.util.ArrayList;

public class FenwickTree {

  ArrayList<Integer> tree;

  public FenwickTree(int n){
    tree = new ArrayList<>();
    for(int i = 0; i < n+1; i++)
      tree.add(0);
  }

  public int sum(int pos){
    ++pos;
    int ret = 0;
    while(pos > 0){
      ret += tree.get(pos);
      pos &= (pos - 1);
    }
    return ret;
  }

  public void add(int pos, int val){
    ++pos;
    while(pos < tree.size()){
      tree.set(pos, tree.get(pos) + val);
      pos += (pos & -pos);
    }
  }

}