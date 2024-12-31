package strategies.chap11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Allergy {

  static int n;
  static int m;
  static List<String> friends = new ArrayList<>();
  static List<int[]> foods = new ArrayList<>();
  static List<List<Integer>> choice = new ArrayList<>();

  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(Allergy.class.getResource(".").getPath() + "input/allergy.txt"));
    int T = sc.nextInt();

    while(T-- > 0){
      n = sc.nextInt();
      m = sc.nextInt();

      friends.clear();
      choice.clear();
      for(int i = 0; i < n; i++) {
        friends.add(sc.next());
        choice.add(new ArrayList<>());
      }

      foods.clear();
      for(int i = 0; i < m; i++){
        int count = sc.nextInt();
        int[] canEat = new int[count];
        for(int j = 0; j < count; j++) {
          int friend = friends.indexOf(sc.next());
          canEat[j] = friend;
          choice.get(friend).add(i);
        }
        foods.add(canEat);
      }
      best = 987654321;
      //slowSearch(0, new int[n], 0);
      search(new int[n], 0);
      System.out.println(best);
    }
  }

  static int best;

  // 안먹은 친구 찾기
  private static void search(int[] edible, int chosen){
    if(chosen >= best) return;

    int first = 0;

    while(first < n && edible[first] > 0) ++first;

    if(first == n) {best = chosen; return;}

    for(int i = 0; i < choice.get(first).size(); i++) {
      int food = choice.get(first).get(i);

      for(int j = 0; j < foods.get(food).length; j++)
        edible[foods.get(food)[j]]++;

      search(edible, chosen + 1);

      for(int j = 0; j < foods.get(food).length; j++)
        edible[foods.get(food)[j]]--;
    }
  }


  // food부터 고를 때 모든 친구가 먹을 때 필요한 가지 수
  private static void slowSearch(int food, int[] edible, int chosen){
    if(chosen >= best) return;

    if(food == m){
      if(Arrays.stream(edible).noneMatch(i -> i == 0))
        best = chosen;
          return;
    }

    slowSearch(food + 1, edible, chosen);

    for(int i = 0; i < foods.get(food).length; i++){
      edible[foods.get(food)[i]]++;
    }

    slowSearch(food + 1, edible, chosen + 1);

    for(int i = 0; i < foods.get(food).length; i++){
      edible[foods.get(food)[i]]--;
    }
  }

}
