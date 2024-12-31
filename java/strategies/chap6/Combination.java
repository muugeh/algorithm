package strategies.chap6;

public class Combination {

  public static void main(String[] args){
    int[] elements = {1,2,3,4,5};
    boolean[] visited = new boolean[elements.length];

    combination(elements, visited, 0, elements.length, 2);
  }

  public static void combination(int[] elements, boolean[] visited, int start, int n, int r){
    if(r == 0) {
      for(int i = 0; i < n; i++)
        if(visited[i]) System.out.print(elements[i] + " ");

      System.out.println();
      return;
    }

    for(int next = start; next < n; ++next){
      visited[next] = true;
      combination(elements, visited, next+1, n, r - 1);
      visited[next] = false;
    }
  }

}
