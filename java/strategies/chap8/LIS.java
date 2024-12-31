package strategies.chap8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class LIS {

  public static void main(String[] args) {
    LinkedList<Integer> A = new LinkedList<>(Arrays.asList(5,1,6,4,3,2,8,7));

    S = new int[]{5, 1, 6, 4, 3, 2, 8, 7};
    cache = new int[101];
    cacheCnt = new int[101];
    n = S.length;

    Arrays.fill(cache, -1);
    Arrays.fill(cacheCnt, -1);

    LinkedList<Integer> lis = new LinkedList<>();

    reconstruct(-1, 5, lis);
    System.out.println(lis);
  }

  static int lis(LinkedList<Integer> A) {
    if (A.isEmpty()) {
      return 0;
    }
    int answer = 0;
    for (int i = 0; i < A.size(); ++i) {
      LinkedList<Integer> B = new LinkedList<>();
      for (int j = i + 1; j < A.size(); ++j) {
        if (A.get(i) < A.get(j)) {
          B.add(A.get(j));
        }
      }
      answer = Math.max(answer, 1 + lis(B));
    }
    return answer;
  }


  static int n;
  static int[] cache;
  static int[] S;

  static int lis3(int start) {
    if (cache[start + 1] != -1) {
      return cache[start + 1];
    }
    cache[start + 1] = 1;

    for (int next = start + 1; next < n; ++next) {
      if (start == -1 || S[start] < S[next]) {
        cache[start + 1] = Math.max(cache[start + 1], lis3(next) + 1);
      }
    }

    return cache[start + 1];
  }

  static int[] cacheCnt;
  static int MAX = 200000000 + 1;

  static int count(int start) {
    if (lis3(start) == 1) {
      return 1;
    }
    int answer = cacheCnt[start + 1];
    if (answer != -1) {
      return answer;
    }
    answer = 0;
    for (int next = start + 1; next < n; next++) {
      if (start == -1 || S[start] < S[next]) {
        if (lis3(start) == lis3(next) + 1) {
          answer = Math.min(MAX, answer + count(next));
        }
      }
    }
    return cacheCnt[start + 1] = answer;
  }

  static void reconstruct(int start, int skip, LinkedList<Integer> lis) {
    if (start != -1) {
      lis.push(S[start]);
    }

    HashMap<Integer, Integer> followers = new HashMap<>();

    for (int next = start + 1; next < n; next++) {
      if (start == -1 || S[start] < S[next]) {
        if (lis3(start) == lis3(next) + 1) {
          followers.put(S[next], next);
        }
      }
    }

    for (Integer integer : followers.keySet()) {
      int idx = followers.get(integer);
      int cnt = count(idx);
      if (cnt <= skip)
        skip -= cnt;
      else {
        reconstruct(idx, skip, lis);
        break;
      }
    }

  }

}
