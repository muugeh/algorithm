package strategies.chap24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MeasureTime {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int C = Integer.parseInt(br.readLine());
    while (C-- > 0) {
      int N = Integer.parseInt(br.readLine());
      ArrayList<Integer> arrayList = new ArrayList<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        arrayList.add(Integer.parseInt(st.nextToken()));
      }
      //bw.write(solve(arrayList) + "\n");
      bw.write(countMoves(arrayList, 0, N-1) + "\n");
      bw.flush();
    }
  }

  private static long solve(ArrayList<Integer> arrayList) {
    FenwickTree fenwickTree = new FenwickTree(1000000);
    long ret = 0;
    for (Integer integer : arrayList) {
      ret += fenwickTree.sum(999999) - fenwickTree.sum(integer);
      fenwickTree.add(integer, 1);
    }
    return ret;
  }

  private static long countMoves(ArrayList<Integer> arrayList, int left, int right) {
    if (left == right) {
      return 0;
    }
    int mid = (left + right) / 2;
    long ret = countMoves(arrayList, left, mid) + countMoves(arrayList, mid + 1, right);
    ArrayList<Integer> tmp = new ArrayList<>(right - left + 1);
    for (int i = 0; i < right - left + 1; i++) {
      tmp.add(0);
    }
    int tmpIndex = 0, leftIndex = left, rightIndex = mid + 1;
    while (leftIndex <= mid || rightIndex <= right) {
      if (leftIndex <= mid &&
          (rightIndex > right || arrayList.get(leftIndex) <= arrayList.get(rightIndex))) {
        tmp.set(tmpIndex++, arrayList.get(leftIndex++));
      } else {
        ret += mid - leftIndex + 1;
        tmp.set(tmpIndex++, arrayList.get(rightIndex++));
      }
    }

    for (int i = 0; i < tmp.size(); i++) {
      arrayList.set(left + i, tmp.get(i));
    }
    return ret;
  }

}