package strategies.chap6;

public class Picnic {

  int n;
  public static boolean[][] areFriends = new boolean[10][10];

  int countPairings(boolean[] taken) {
    // 기저 사례: 모든 학생이 짝을 찾았으면 종료
    boolean finished = true;
    for (int i = 0; i < n; ++i) {
      if (!taken[i]) {
        finished = false;
      }
    }
    if (finished) {
      return 1;
    }
    int answer = 0;
    // 서로 친구인 두 학생을 찾아 짝을 지어 준다.
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (!taken[i] && !taken[j] && areFriends[i][j]) {
          taken[i] = taken[j] = true;
          answer += countPairings(taken);
          taken[i] = taken[j] = false;
        }
      }
    }
    return answer;
  }

  int fixCountPairings(boolean[] taken) {
    // 남은 학생 중 가장 번호 빠른 학생을 찾습니다.
    int firstFree = -1;
    for(int i = 0; i < n; ++i){
      if(!taken[i]){
        firstFree = i;
        break;
      }
    }
    // 기저 사례: 모든 학생이 짝을 찾으면 종료
    if(firstFree == -1) return 1;
    int answer = 0;
    // 이 학생과 짝지을 학생을 결정합니다.
    for(int pairWith = firstFree+1; pairWith < n; ++pairWith){
      if(!taken[pairWith] && areFriends[firstFree][pairWith]){
        taken[firstFree] = taken[pairWith] = true;
        answer += fixCountPairings(taken);
        taken[firstFree] = taken[pairWith] = false;
      }
    }
    return answer;
  }

  public static void main(String[] args) {

    Picnic picnic = new Picnic();

    picnic.n = 6;
    int[] ma = {0, 1, 0, 2, 1, 2, 1, 3, 1, 4, 2, 3, 2, 4, 3, 4, 3, 5, 4, 5};
    int m = 10;
    for (int i = 0; i < m * 2; i += 2) {
      areFriends[ma[i]][ma[i + 1]] = true;
      areFriends[ma[i + 1]][ma[i]] = true;
    }

    System.out.println(picnic.fixCountPairings(new boolean[6]));
  }

}
