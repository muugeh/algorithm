package strategies.chap15;

public class LineIntersection {

  public static void main(String[] args){

  }

  private final static double EPSILON = 1e-9;

  boolean lineIntersection(Vector2 a, Vector2 b, Vector2 c, Vector2 d, Vector2 e, Vector2 x){
    double det = (b.sub(a).cross(d.sub(c)));
    // 두 선이 평인 경우
    if(Math.abs(det) < EPSILON) return false;
    x = a.add(b.sub(a)).multiply(c.sub(a).cross(d.sub(c)) / det);
    return true;
  }


}