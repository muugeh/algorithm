package strategies.chap13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Roots {

  // 단일 변수 다항식 p의 계수가 주어질 때 미분한 결과 p'의 계수를 반환한다.
  List<Double> differentiate(List<Double> poly){
    List<Double> derivative = new ArrayList<>();
    for(int i = 0; i < poly.size(); i++){
      derivative.add(poly.get(i) * i);
    }
    derivative.remove(0);
    return derivative;
  }

  // 1차 혹은 2차 방정식을 푼다.
  List<Double> solveNaive(List<Double> poly){
    List<Double> solution = new ArrayList<>();

    return solution;
  }

  // 다항식 f(x)의 계수 poly가 주어질 때, f(x0)을 반환한다.

  double evaluate(List<Double> poly, double x0){
    double value = 0;
    for(int i = 0; i < poly.size(); i++){
      int count = i;
      double partValue = poly.get(i);
      while(count-- > 0){
        partValue *= x0;
      }
      value += partValue;
    }
    return value;
  }



  // 방정식의 해는 절대 값 L이하여야 한다.
  final static double L = 25;

  // 방정식 sum(poly[i]*x^i) = 0의 근을 반환한다.
  List<Double> solve (List<Double> poly){
    int n = poly.size() - 1;
    // 기저 사례: 2차 이하의 방정식들은 풀 수 있다.
    List<Double> derivative = differentiate(poly);
    List<Double> sols = solve(derivative);

    sols.add(0, -L-1);
    sols.add(L + 1);
    List<Double> answer = new ArrayList<>();
    for(int i = 0; i+1 < sols.size(); i++){
      double x1 = sols.get(i), x2 = sols.get(i+1);
      double y1 = evaluate(poly, x1), y2 = evaluate(poly, x2);
      if(y1 * y2 > 0) continue;
      if(y1 > y2) {
        double tmp = y1;
        y1 = y2;
        y2 = tmp;

        tmp = x1;
        x1 = x2;
        x2 = tmp;
      }

      for(int iter = 0; iter < 100; iter++){
        double mx =(x1 + x2) / 2;
        double my = evaluate(poly, mx);
        if(y1 * my > 0){
          y1 = my;
          x1 = mx;
        } else {
          y2 = my;
          x2 = mx;
        }
      }
      answer.add((x1 + x2) / 2);
    }
    Collections.sort(answer);
    return answer;
  }

}
