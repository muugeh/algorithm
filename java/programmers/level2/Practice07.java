package programmers.level2;

// [다리를 지나는 트럭] https://programmers.co.kr/learn/courses/30/lessons/42583

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Practice07 {
  public static void main(String[] args) {
    int bridge_length = 100;
    int weight = 100;
    int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    System.out.println(solution(bridge_length, weight, truck_weights));
  }

  public static int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    Stack<Integer> wait = new Stack<>();
    for (int i = truck_weights.length - 1; i >= 0; i--) {
      wait.push(truck_weights[i]);
    }
    Queue<Truck> move = new ArrayDeque<>();
    int sum = 0;
    while (!wait.isEmpty() || !move.isEmpty()) {
      if (!wait.isEmpty() && sum + wait.peek() <= weight) {
        int truck_weight = wait.pop();
        move.add(new Truck(0, truck_weight));
        sum += truck_weight;
      }

      answer++;
      for (Truck truck : move) {
        truck.time++;
        if (truck.time == bridge_length) {
          sum -= truck.weight;
          move.poll();
        }
      }
    }

    return answer + 1;
  }

  private static class Truck {
    int time;
    int weight;

    public Truck(int time, int weight) {
      this.time = time;
      this.weight = weight;
    }
  }
}
