package strategies.chap4;

public class Boggle {

  private char[][] board = {{'a', 'b', 'c', 'd', 'e'}, {'a', 'd', 'd', 'e', 'c'}};


  private static final int[] dx = {-1, -1, -1, 1, 1, 1, 0, 0};
  private static final int[] dy = {-1, 0, 1, -1, 0, 1, -1, 1};

//  boolean hasWord(int y, int x, final String word) {
//    // 기저 사례 1: 시작 위치가 범위 밖이면 무조건 실패
//    if (!inRange(y, x)) return false;
//    // 기저 사례 2: 첫 글자가 일치하지 않으면 실패
//    if (board[y][x] != word.charAt(0)) return false;
//    // 기저 사례: 단어 길이가 1이면 성공
//    if (word.length() == 1) return true;
//    // 인접한 여덟 칸을 검사한다.
//    for(int direction = 0; direction < 8; ++direction){
//      int nextY = y + dy[direction], nextX = x + dx[direction];
//      //다음 칸이 범위 안에 있느지, 첫 글자 일치하나 확인할 필요 X
//      if(hasWord(nextY, nextX, word.substring(1))) return true;
//    }
//    return false;
//  }


  public static void main(String[] args) {
    Boggle boggle = new Boggle();


  }

}
