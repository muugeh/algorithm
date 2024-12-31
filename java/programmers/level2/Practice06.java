package programmers.level2;

// [JadenCase 문자열 만들기] https://programmers.co.kr/learn/courses/30/lessons/12951

public class Practice06 {
  public static void main(String[] args) {
    String s = "3people unFollowed me";
    System.out.println(solution(s)); // "3people Unfollowed Me"
  }

  private static String solution(String s) {
    StringBuilder sb = new StringBuilder(s);
    boolean start = false;
    for(int i = 0; i < sb.length(); i++){
      if(sb.charAt(i) == ' '){
        start = false;
        continue;
      }
      if(!start){
        start = true;
        sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
      } else{
        sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
      }
    }
    return sb.toString();
  }

}
