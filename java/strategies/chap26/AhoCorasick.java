package strategies.chap26;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AhoCorasick {

  private final static int ALPHABETS = 26;
  int terminal;
  AhoCorasick fail;
  List<Integer> output;
  AhoCorasick[] children;

  public void computeFailFunc(AhoCorasick root){
    Queue<AhoCorasick> q = new LinkedList<>();
    // 루트의 실패 연결은 자기 자신
    root.fail = root;
    q.add(root);

    while(!q.isEmpty()){
      AhoCorasick here = q.poll();
      for(int edge = 0; edge < ALPHABETS; edge++){
        AhoCorasick child = here.children[edge];
        if(child == null) continue;
        if(here == root)
          child.fail = root;
        else{
          AhoCorasick t = here.fail;
          while(t != root && t.children[edge] == null)
            t = t.fail;
          if(t.children[edge] != null) t = t.children[edge];
          child.fail = t;

          child.output = child.fail.output;
          if(child.terminal != -1)
            child.output.add(child.terminal);
          q.add(child);
        }
      }
    }
  }
}