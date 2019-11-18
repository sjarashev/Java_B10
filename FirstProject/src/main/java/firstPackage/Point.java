package firstPackage;

public class Point {

  public double p1;
  public double p2;

  public Point(double p1, double p2){
    this.p1 = p1;
    this.p2 = p2;
  }

  public double calculateDistance(){
    double r = this.p2 - this.p1;
    return r;
  }

}
