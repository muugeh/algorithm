package strategies.chap28;

import java.util.ArrayList;
import java.util.List;

public class DfsAllVisit {

  public static void main(String[] args){

    dfsAll();
  }

  private static List<List<Integer>> adj = new ArrayList<>();
  private static List<Boolean> visited = new ArrayList<>();

  private static void dfs(int here){
    System.out.println("DFS visited " + here);
    visited.set(here, true);
    for(int i = 0; i < adj.get(here).size(); i++){
      int there = adj.get(here).get(i);
      if(!visited.get(there))
        dfs(there);
    }
  }

  private static void dfsAll(){
    for(int i = 0; i < adj.size(); i++)
      if(!visited.get(i))
        dfs(i);
  }

}