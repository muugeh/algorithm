package greedy.boj;

// [잃어버린 괄호] https://www.acmicpc.net/problem/1541

import java.io.*;

public class BOJ1541 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = br.readLine();
    String[] operand = line.split("[+\\-]");
    int index = 0;
    int sum = 0;
    boolean minus = false;
    for (int i = 0; i < operand.length; i++) {
      int n = Integer.parseInt(operand[i]);
      if (i == 0) {
        sum = n;
      } else {
        String operator = line.substring(index, index + 1);
        index += 1;
        if (!minus && operator.equals("+"))
          sum += n;
        else {
          minus = true;
          sum -= n;
        }
      }
      index += operand[i].length();
    }
    bw.write(String.valueOf(sum));
    bw.flush();
    bw.close();
    br.close();
  }

}
