package strategies.chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sort {

  void selectionSort(LinkedList<Integer> array) {
    for (int i = 0; i < array.size(); i++) {
      int minIndex = i;
      for (int j = i + 1; j < array.size(); ++j) {
        if (array.get(minIndex) > array.get(j)) {
          minIndex = j;
        }
      }
      Collections.swap(array, minIndex, i);
    }
  }

  void insertionSort(LinkedList<Integer> array) {
    for (int i = 0; i < array.size(); ++i) {
      // 불변식 1: array[a ... i]는 이미 정렬
      int j = i;
      while (j > 0 && array.get(j - 1) > array.get(j)) {
        // 불변식 2: array[j+1 ... i]의 모든 원소는 A[j]보다 큼
        // 불변식 3: array[0 .. i] 구간은 A[j]를 제외하면 모두 정렬
        Collections.swap(array, j - 1, j);
        --j;
      }
    }
  }

  static List<Integer> mergeSort(List<Integer> array) {
    if (array.size() == 1) {
      return array;
    }

    int lo = 0;
    int hi = array.size();

    int mid = (lo + hi) / 2;
    if (lo + hi % 2 == 1) {
      mid += 1;
    }

    List<Integer> merge = new ArrayList<>();
    List<Integer> left = mergeSort(array.subList(lo, mid));
    List<Integer> right = mergeSort(array.subList(mid, hi));

    int leftNext = 0;
    int rightNext = 0;
    int leftMax = left.size();
    int rightMax = right.size();

    while (leftNext < leftMax && rightNext < rightMax) {
      if (left.get(leftNext) < right.get(rightNext)) {
        merge.add(left.get(leftNext));
        leftNext++;
      } else {
        merge.add(right.get(rightNext));
        rightNext++;
      }

    }
    if (leftNext < leftMax) {
      merge.addAll(left);
    }
    if (rightNext < rightMax) {
      merge.addAll(right);
    }

    return merge;
  }



  public static void merge_sort(int[] a, int left, int right) {

    if (left == right) {
      return;
    }

    int mid = (left + right) / 2;

    merge_sort(a, left, mid);
    merge_sort(a, mid + 1, right);

    merge(a, left, mid, right);

  }

  private static int[] sorted;

  private static void merge(int[] a, int left, int mid, int right) {
    int l = left;
    int r = mid + 1;
    int idx = left;

    while (l <= mid && r <= right) {
      if (a[l] <= a[r]) {
        sorted[idx] = a[l];
        idx++;
        l++;
      }
    }

  }


  public static void main(String[] args) {
//        Sort sort = new Sort();
//        LinkedList<Integer> selectList = new LinkedList(Arrays.asList(6, 4, 2, 8, 10));
//        LinkedList<Integer> insertList = new LinkedList(Arrays.asList(6, 4, 2, 8, 10));
//        sort.selectionSort(selectList);
//        sort.insertionSort(insertList);
//        System.out.println(selectList);
//        System.out.println(insertList);

    ArrayList<Integer> mergeList = new ArrayList<>(Arrays.asList(6, 4, 2, 8, 10));
    System.out.println(mergeSort(mergeList));


  }

}
