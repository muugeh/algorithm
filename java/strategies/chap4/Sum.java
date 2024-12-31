package strategies.chap4;

import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.Math.max;


public class Sum {

  int inefficientMaxSum(LinkedList<Integer> list) {
    int size = list.size();
    int answer = Integer.MIN_VALUE;

    for (int i = 0; i < size; i++) {
      for (int j = i; j < size; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += list.get(k);
        }

        if (sum > answer) {
          answer = sum;
        }
      }
    }
    return answer;
  }


  int betterMaxSum(LinkedList<Integer> list) {
    int size = list.size();
    int answer = Integer.MIN_VALUE;

    for (int i = 0; i < size; i++) {
      int sum = 0;
      for (int j = i; j < size; j++) {
        sum += list.get(j);

        if (answer < sum) {
          answer = sum;
        }
      }
    }
    return answer;
  }

  int MIN = Integer.MIN_VALUE;

  int fastMaxSum(LinkedList<Integer> list, int lo, int hi) {
    if (lo == hi) {
      return list.get(lo);
    }

    int mid = (lo + hi) / 2;

    int left = MIN, right = MIN, sum = 0;
    for (int i = mid; i >= lo; --i) {
      sum += list.get(i);
      left = max(left, sum);
    }

    sum = 0;
    for (int i = mid + 1; i <= hi; ++i) {
      sum += list.get(i);
      right = max(right, sum);
    }

    int single = max(fastMaxSum(list, lo, mid),
                     fastMaxSum(list, mid + 1, hi));

    return max(left + right, single);
  }

  int fastestMaxSum(LinkedList<Integer> list) {
    int answer = Integer.MIN_VALUE;
    int partialSum = 0;

    for (Integer i : list) {
      partialSum = Math.max(partialSum, 0) + i;
      answer = max(partialSum, answer);
    }
    return answer;
  }

  static int fastSum(int n) {
    if (n == 1) {
      return 1;
    }
    if (n % 2 == 1) {
      return fastSum(n - 1) + n;
    }
    return 2 * fastSum(fastSum(n / 2)) + (n / 2) * (n / 2);
  }


  public static void main(String args[]) {
    Sum sum = new Sum();
    LinkedList<Integer> linkedList = new LinkedList(Arrays.asList(-7, 4, -3, 6, 3, -8, 3, 4));

    // int max = sum.fastestMaxSum(linkedList);
  }

}
