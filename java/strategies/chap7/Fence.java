package strategies.chap7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import util.Input;

public class Fence {

  public static void main(String[] args) throws Exception{
    Scanner sc = Input.sc(new Fence());

    int C = sc.nextInt();
    while (C-- > 0) {
      int N = sc.nextInt();
      ArrayList<Integer> board = new ArrayList<>();
      for(int i = 0; i < N; i++){
        board.add(sc.nextInt());
      }
      System.out.println(solveStack(board));
    }
  }

  private static int fence(List<Integer> board) {
    if(board.size() == 1) return board.get(0);

    int lo = 0;
    int hi = board.size();

    int mid = (lo + hi) / 2;

    int leftMax = fence(board.subList(lo, mid));
    int rightMax = fence(board.subList(mid, hi));

    int answer = Math.max(leftMax, rightMax);

    int left = mid - 1;
    int right = mid;

    int height = Math.min(board.get(left), board.get(right));

    while(left > lo && right < hi){
      if(right < hi - 1 && (lo == left - 1 || board.get(left - 1) < board.get(right + 1))){
        ++right;
        height = Math.min(height, board.get(right));
      } else{
        --left;
        height = Math.min(height, board.get(left));
      }
      answer = Math.max(answer, height * (right - left + 1));
    }
    return answer;
  }

  private static int solveStack(List<Integer> board){
    Stack<Integer> remaining = new Stack<>();
    remaining.add(0);
    int ret = 0;

    for(int i = 0; i < board.size(); i++){
      while(!remaining.isEmpty() && board.get(remaining.peek()) >= board.get(i)){
        int j = remaining.peek();
        remaining.pop();
        int width = -1;

        if(remaining.isEmpty())
          width = i;
        else
          width = (i - remaining.peek() - 1);

        ret = Math.max(ret, board.get(j) * width);
      }
      remaining.add(i);
    }
    return ret;
  }

}
