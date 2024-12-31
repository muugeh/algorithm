package strategies.chap12;

import java.util.List;

public class Darpa {

  // 결정 문제: 정렬되어 있는 locations 중 cameras를 선택
  // 모든 카메라 간의 간격이 gap 이상되는 방법이 있는지 반환
  boolean decision(List<Double> location, int cameras, double gap){

    double limit = -1;
    int installed = 0;
    for(int i = 0; i < location.size(); i++){
      if(limit <= location.get(i)){
        ++installed;
        limit = location.get(i) + gap;
      }
    }

    return installed >= cameras;
  }

  double optimize(List<Double> location, int cameras){
    double lo = 0, hi = 241;
    for(int it = 0; it < 100; ++it){
      double mid = (lo + hi) / 2.0;
      if(decision(location, cameras, mid))
        lo = mid;
      else
        hi = mid;
    }
    return lo;
  }

}
