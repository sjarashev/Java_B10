package firstPackage;

public class Run {

  public static void humanWeight() {

    Height h = new Height(178);

    System.out.println("Pri roste cheloveka v " + h.high + " cm, ego ves doljen sostavlyat " + h.bodyMassIndex() + " kg");
  }

  public static void resultOfCalculation(){

    Point p = new Point(1,9);

    System.out.println("Rastoyanie mejdu tochkami X and Y ravno " + p.calculateDistance() + " cm");

  }
}
