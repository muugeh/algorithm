package string.boj;

// [크로아티아 알파벳] https://www.acmicpc.net/problem/2941

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ2941 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String word = br.readLine();
    Set<String> special = Stream.of("c=", "c-", "dz", "d-", "lj", "nj", "s=", "z=").collect(Collectors.toSet());
    int count = word.length();
    for(int i = 0; i < word.length() - 1; i++){
      if(special.contains(word.substring(i, i+2))){
        if(word.startsWith("dz", i)) {
          if (i != word.length() - 2 && word.charAt(i + 2) == '=') {
            count--;
            i++;
          } else {
            continue;
          }
        }
        count--;
        i++;
      }
    }
    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
    br.close();
  }

}
