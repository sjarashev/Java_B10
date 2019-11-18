package firstPackage;

public class Height {

  public int high;

  public Height(int high) {
    this.high = high;
  }
  public int bodyMassIndex() {

    int j = 110;

    int i = this.high - j;
    return i;

  }
}
