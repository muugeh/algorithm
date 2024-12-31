package string.boj;

// [다이얼] https://www.acmicpc.net/problem/5622

import java.io.*;

public class BOJ5622 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = br.readLine();
    int count = 0;
    for (int i = 0; i < line.length(); i++)
      count += getDial(line.charAt(i));
    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
    br.close();
  }

  private static int getDial(char alphabet) {
    switch (alphabet) {
      case 'A':
      case 'B':
      case 'C':
        return 3;
      case 'D':
      case 'E':
      case 'F':
        return 4;
      case 'G':
      case 'H':
      case 'I':
        return 5;
      case 'J':
      case 'K':
      case 'L':
        return 6;
      case 'M':
      case 'N':
      case 'O':
        return 7;
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
        return 8;
      case 'T':
      case 'U':
      case 'V':
        return 9;
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
        return 10;
      default:
        return 0;
    }
  }

}
