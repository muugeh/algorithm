package strategies.chap4;

import java.util.LinkedList;

public class Pick {

  void pick(int n, LinkedList<Integer> picked, int toPick){
    // 기저 사례: 더 고를 원소가 없을 때 고른 원소를 출력
    if(toPick == 0){ System.out.println(picked); return; }
    // 고를 수 있는 가장 작은 번호를 계산한다.
    int smallest = picked.isEmpty() ? 0 : picked.getFirst() + 1;
    for(int next = smallest; next < n; ++next){
      picked.push(next);
      pick(n, picked, toPick - 1);
      picked.pop();
    }
  }


  public static void main(String[] args){
    Pick pick = new Pick();
    pick.pick(3, new LinkedList<>(), 3);

  }

}
