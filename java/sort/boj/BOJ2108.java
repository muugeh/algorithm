package sort.boj;

// [통계학] https://www.acmicpc.net/problem/2108

import java.io.*;
import java.util.*;

public class BOJ2108 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] array = new int[n];
    int min = 4001;
    int max = -4001;
    Map<Integer, Integer> count = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      array[i] = Integer.parseInt(br.readLine());
      max = Math.max(max, array[i]);
      min = Math.min(min, array[i]);
      count.put(array[i], count.getOrDefault(array[i], 0) + 1);
    }
    Arrays.sort(array);

    int maxMode = -1;
    int modeIndex = -1;
    boolean checked = false;
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      int value = entry.getValue();
      if (maxMode < value) {
        maxMode = value;
        modeIndex = entry.getKey();
        checked = false;
      } else if (maxMode == value && !checked) {
        modeIndex = entry.getKey();
        checked = true;
      }
    }

    int arithmetic = (int) Math.round((double) Arrays.stream(array).sum() / n);
    int middle = array[n / 2];
    int secondMode = modeIndex;
    int range = max - min;
    String sb = arithmetic + "\n" + middle + "\n" + secondMode + "\n" + range;
    bw.write(sb);
    bw.flush();
    bw.close();
    br.close();
  }

}
