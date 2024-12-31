package strategies.chap20;

import java.util.ArrayList;
import java.util.List;

public class Search {

  public static void main(String[] args) {

    System.out.println(kmpSearch("appleappleappleappl", "apple"));
    System.out.println(getPrefixSuffix("ababbaba"));
  }

  static List<Integer> naiveSearch(String H, String N) {
    List<Integer> answer = new ArrayList<>();

    for (int begin = 0; begin + N.length() <= H.length(); ++begin) {
      boolean matched = true;
      for (int i = 0; i < N.length(); i++) {
        if (H.charAt(i + begin) != N.charAt(i)) {
          matched = false;
          break;
        }
      }
      if (matched) {
        answer.add(begin);
      }
    }
    return answer;
  }

  static List<Integer> kmpSearch(String H, String N) {
    int n = H.length();
    int m = N.length();

    List<Integer> answer = new ArrayList<>();
    List<Integer> pi = getPartialMatchNaive(N);

    int begin = 0, matched = 0;
    while (begin <= n - m) {
      if (matched < m && H.charAt(begin + matched) == N.charAt(matched)) {
        matched++;
        if (matched == m) {
          answer.add(begin);
        }
      } else {
        if (matched == 0) {
          ++begin;
        } else {
          begin += matched - pi.get(matched - 1);
          matched = pi.get(matched - 1);
        }
      }

    }
    return answer;
  }

  static List<Integer> getPartialMatchNaive(String N) {
    int m = N.length();
    List<Integer> pi = new ArrayList<>();
    for(int i = 0; i < m; i++)
      pi.add(0);

    for (int begin = 1; begin < m; ++begin) {
      for (int i = 0; i + begin < m; ++i) {
        if (N.charAt(begin + i) != N.charAt(i)) {
          break;
        }
        pi.set(begin + i, Math.max(pi.get(begin + i), i + 1));
      }
    }
    return pi;
  }

  public static List<Integer> getPartialMatch(String N){
    int m = N.length();
    List<Integer> pi = new ArrayList<>();
    for(int i = 0; i < m; i++)
      pi.add(0);

    int begin = 1, matched = 0;

    while(begin + matched < m){
      if(N.charAt(begin + matched) == N.charAt(matched)){
        ++matched;
        pi.set(begin + matched - 1, matched);
      } else{
        if(matched == 0)
          ++begin;
        else{
          begin += matched - pi.get(matched - 1);
          matched = pi.get(matched -1 );
        }
      }
    }
    return pi;
  }

  static List<Integer> getPrefixSuffix(String s){
    List<Integer> ret = new ArrayList<>();
    List<Integer> pi = getPartialMatch(s);
    int k = s.length();
    while(k > 0){
      ret.add(k);
      k = pi.get(k-1);
    }
    return ret;
  }
}




