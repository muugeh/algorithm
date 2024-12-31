package strategies.chap28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dictionary {

  private static final String CONTRADICTION = "INVALID HYPOTHESIS";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int c = Integer.parseInt(br.readLine());
    while (c-- > 0) {
      int n = Integer.parseInt(br.readLine());
      List<String> dictionary = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        dictionary.add(br.readLine());
      }
      makeGraph(dictionary);
      solve();
    }
  }

  private static List<List<Boolean>> adj;
  private static List<Boolean> seen = new ArrayList<>();
  private static List<Integer> order = new ArrayList<>();

  private static void makeGraph(List<String> dictionary) {
    adj = new ArrayList<>();
    for(int i = 0; i < 26; i++){
      adj.add(new ArrayList<>());
      for(int j = 0; j < 26; j++){
        adj.get(i).add(false);
      }
    }

    for(int j = 1; j < dictionary.size(); ++j){
      int i = j - 1;
      int len = Math.min(dictionary.get(i).length(), dictionary.get(j).length());
      for(int k = 0; k < len; ++k)
        if(dictionary.get(i).charAt(k) != dictionary.get(j).charAt(k)){
          int a = dictionary.get(i).charAt(k) - 'a';
          int b = dictionary.get(j).charAt(k) - 'a';
          adj.get(a).set(b, true);
          break;
        }
    }
  }

  private static void dfs(int here) {
    seen.set(here, true);
    for(int there = 0; there < adj.get(here).size(); there++){
      if(adj.get(here).get(there) && !seen.get(there))
        dfs(there);
    }
    order.add(here);
  }

  private static List<Integer> topologicalSort(){
    int m = adj.size();
    seen = new ArrayList<>();
    for(int i = 0; i < m; i++)
      seen.add(false);

    order = new ArrayList<>();
    for(int i = 0; i < m; i++)
      if(!seen.get(i)) dfs(i);

    Collections.reverse(order);

    for(int i = 0; i < m; i++){
      for(int j = i+1; j < m; j++)
        if(adj.get(order.get(j)).get(order.get(i)))
          return new ArrayList<>();
    }
    return order;
  }

  private static void solve(){
    List<Integer> graph = topologicalSort();
    if(graph.size() == 0) {
      System.out.println(CONTRADICTION);
      return;
    }
    for (Integer integer : graph)
      System.out.print((char) (integer + 'a'));
    System.out.println();
  }

}