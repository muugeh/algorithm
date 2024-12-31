package strategies.chap20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class JaehaSafe {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int C = Integer.parseInt(br.readLine());
    while(C-- > 0){
      int N = Integer.parseInt(br.readLine()) + 1;
      List<String> dials = new ArrayList<>();

      while(N-- > 0) dials.add(br.readLine());

      bw.write(String.valueOf(solve(dials)));
      bw.newLine();
      bw.flush();
    }

  }

  private static int solve(List<String> dials) {
    int count = 0;
    String now = dials.get(0);
    int n = now.length();

    for(int i = 1; i < dials.size(); i++){
      if(dials.get(i).equals(now)) continue;
      for(int move = 1; move < n; move++){
        int cut = i % 2 == 1 ? n - move : move;
        String s = now.substring(cut) + now.substring(0, cut);
        if(s.equals(dials.get(i))){
          count += move;
          now = dials.get(i);
          break;
        }
      }
    }
    return count;
  }

}