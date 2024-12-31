package strategies.chap7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSort {

  public static void main(String[] args){
    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(4,5,2,2,3,1));

    System.out.println(quickSort(array));
  }

  private static List<Integer> quickSort(List<Integer> list) {
    if(list.size() == 1) return list;
    int pivot = list.get(0);

    List<Integer> left = new LinkedList<>();
    List<Integer> right = new LinkedList<>();
    List<Integer> equal = new LinkedList<>();
    List<Integer> merge = new LinkedList<>();

    for(int i = 1; i < list.size(); i++){
      if(list.get(i) < pivot) left.add(list.get(i));
      else if(list.get(i) == pivot) equal.add(list.get(i));
      else right.add(list.get(i));
    }

    left = quickSort(left);
    equal.add(pivot);
    right = quickSort(right);

    merge.addAll(left);
    merge.addAll(equal);
    merge.addAll(right);

    return merge;
  }

}
