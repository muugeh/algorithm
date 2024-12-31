package strategies.chap24;

import java.util.ArrayList;

public class RMQ {

  int n;
  ArrayList<Integer> rangeMin;

  public RMQ(int[] array) {
    n = array.length;
    rangeMin = new ArrayList<>(n * 4);
    for (int i = 0; i < n * 4; i++) {
      rangeMin.add(0);
    }
    init(array, 0, n - 1, 1);
  }

  public int init(int[] array, int left, int right, int node) {
    if (left == right) {
      rangeMin.set(node, array[left]);
      return rangeMin.get(node);
    }
    int mid = (left + right) / 2;
    int leftMin = init(array, left, mid, node * 2);
    int rightMin = init(array, mid + 1, right, node * 2 + 1);
    rangeMin.set(node, Math.min(leftMin, rightMin));
    return rangeMin.get(node);
  }

  static final int INT_MAX = Integer.MAX_VALUE;

  // node가 표현하는 범위 array[nodeLeft, nodeRight]가 주어질 때
  // 이 범위와 array[left...right]의 교집합의 최소치
  private int query(int left, int right, int node, int nodeLeft, int nodeRight) {
    if (right < nodeLeft || nodeRight < left) {
      return INT_MAX;
    }

    if (left <= nodeLeft && nodeRight <= right) {
      return rangeMin.get(node);
    }

    int mid = (nodeLeft + nodeRight) / 2;
    return Math.min(query(left, right, node * 2, nodeLeft, mid),
                    query(left, right, node * 2 + 1, mid + 1, nodeRight));
  }

  // query()를 외부에서 호출하기 위한 인터페이스
  public int query(int left, int right) {
    return query(left, right, 1, 0, n - 1);
  }

  private int update(int index, int newValue, int node, int nodeLeft, int nodeRight) {
    if (index < nodeLeft || nodeRight < index) {
      return rangeMin.get(node);
    }
    if (nodeLeft == nodeRight) {
      return rangeMin.set(node, newValue);
    }
    int mid = (nodeLeft + nodeRight) / 2;
    return rangeMin.set(node, Math.min(update(index, newValue, node * 2, nodeLeft, mid),
                                       update(index, newValue, node * 2 + 1, mid + 1, nodeRight)));
  }

  public int update(int index, int newValue){
    return update(index, newValue, 1, 0, n-1);
  }
}