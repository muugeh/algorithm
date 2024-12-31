package strategies.chap22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Insertion {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int C = Integer.parseInt(br.readLine());
    while(C-- > 0){
      int N = Integer.parseInt(br.readLine());
      List<Integer> moved = new ArrayList<>();
      StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

      while(N-- >0){
        moved.add(Integer.parseInt(stringTokenizer.nextToken()));
      }

      List<Integer> original = recover(moved);
      for(Integer i : original)
        System.out.print(i + " ");
      System.out.println();
    }
  }

  private static List<Integer> recover(List<Integer> moved) {
    List<Integer> sorted = new ArrayList<>();
    List<Integer> answer = new ArrayList<>();
    for(int i = 0; i < moved.size(); i++)
      sorted.add(i+1);

    for(int i = moved.size() - 1; i >= 0; i--){
      answer.add(sorted.get(i - moved.get(i)));
      sorted.remove(i - moved.get(i));
    }
    Collections.reverse(answer);
    return answer;
  }

}