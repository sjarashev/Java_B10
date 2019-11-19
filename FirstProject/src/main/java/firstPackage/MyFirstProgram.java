package firstPackage;

public class MyFirstProgram {

  public static void main(String[] args) {

    Point p1 = new Point(2, 3);

    Point p2 = new Point(4, 5);

    System.out.println("Растояние между точками p1 и p2 = " + p1.distance(p2));

  }

}