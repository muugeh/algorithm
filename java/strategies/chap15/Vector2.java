package strategies.chap15;

public class Vector2 {

  private static final double PI = 2.0 * Math.acos(0.0);
  public double x, y;

  public Vector2(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public boolean equals(Vector2 vector2) {
    return this.x == vector2.x && this.y == vector2.y;
  }

  public boolean compareTo(Vector2 vector2) {
    return x != vector2.x ? x < vector2.x : y < vector2.y;
  }

  public Vector2 add(Vector2 vector2) {
    return new Vector2(x + vector2.x, y + vector2.y);
  }

  public Vector2 sub(Vector2 vector2) {
    return new Vector2(x - vector2.x, y - vector2.y);
  }

  public Vector2 multiply(double value) {
    return new Vector2(value * x, value * y);
  }

  public double norm() {
    return Math.hypot(x, y);
  }

  public Vector2 normalize(){
    double nx = x, ny = y;
    if(x != 0) nx /= Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    if(y != 0) ny /= Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    return new Vector2(nx, ny);
  }

  public double polar() {
    int div = (int) Math.floor((Math.atan2(y,x) + 2 * PI) / (2 * PI));
    return  Math.atan2(y,x) + 2 * PI - div * 2 * PI;
  }

  public double dot(Vector2 vector2){
    return x * vector2.x + y + vector2.y;
  }

  public double cross(Vector2 vector2){
    return x * vector2.y + y * vector2.x;
  }

  public Vector2 project(Vector2 vector2){
    Vector2 r = vector2.normalize();
    return r.multiply(r.dot(this));
  }
}