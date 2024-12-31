package sort.boj;

// [소트인사이드] https://www.acmicpc.net/problem/1427

import java.io.*;
import java.util.Arrays;

public class BOJ1427 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    char[] numbers = br.readLine().toCharArray();
    Arrays.sort(numbers);
    for(int i = numbers.length - 1; i >= 0; i--){
      bw.write(numbers[i]);
    }
    bw.flush();
    bw.close();
    br.close();
  }

}
