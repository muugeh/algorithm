package strategies.chap20;

import java.util.List;

public class Palindromize {

  public static void main(String[] args){

    String s = "anon";
    String reverse = new StringBuilder(s).reverse().toString();
    System.out.println(s + reverse.substring(maxOverlap("anon")));

  }

  static int maxOverlap(String s){
    StringBuilder stringBuilder = new StringBuilder(s);
    String reverse = stringBuilder.reverse().toString();

    int n = s.length();
    List<Integer> pi = Search.getPartialMatch(reverse);
    int begin = 0, matched = 0;
    while(begin < n){
      if(matched < n && s.charAt(begin + matched) == reverse.charAt(matched)){
        ++matched;
        if(begin + matched == n)
          return matched;
      }
      else{
        if(matched == 0)
          ++begin;
        else{
          begin += matched - pi.get(matched - 1);
          matched = pi.get(matched - 1);
        }
      }
    }
    return 0;
  }

}