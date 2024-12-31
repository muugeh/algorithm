package string.boj;

// [속타는 저녁 메뉴] https://www.acmicpc.net/problem/11585

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ11585 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String menu = br.readLine().replace(" ", "");
    String original = br.readLine().replace(" ", "");

    System.out.println(calculate(n, count(menu, original)));
  }

  private static String calculate(int length, int count){
    int gcd = gcd(length, count);
    int denominator = length / gcd;
    int numerator = count / gcd;
    return numerator + "/" + denominator;
  }

  private static int gcd(int a, int b){
    while(b != 0){
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

  private static int count(String menu, String original) {
    List<Integer> partialMatch = getPartialMatch(menu);
    String expand = original + original;

    int count = 0;
    int begin = 0;
    int matched = 0;
    int e = expand.length();
    int m = menu.length();

    while(begin < e - m){
      if(matched < m && expand.charAt(begin + matched) == menu.charAt(matched)) {
        matched++;

        if (matched == m)
          count++;
      }
      else{
        if(matched == 0)
          ++begin;
        else{
          begin += matched - partialMatch.get(matched - 1);
          matched = partialMatch.get(matched - 1);
        }
      }
    }

    return count;
  }

  private static List<Integer> getPartialMatch(String original){
    List<Integer> partialMatch = new ArrayList<>();
    for(int i = 0; i < original.length(); i++)
      partialMatch.add(0);

    int length = original.length();
    int begin = 1;
    int matched = 0;

    while(begin + matched < length){
      if(original.charAt(begin + matched) == original.charAt(matched)){
        ++matched;
        partialMatch.set(begin + matched - 1, matched);
      }
      else{
        if(matched == 0)
          ++begin;
        else{
          begin += matched - partialMatch.get(matched - 1);
          matched = partialMatch.get(matched - 1);
        }
      }
    }
    return partialMatch;
  }
}
