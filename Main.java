public class Main{
  public static void main(String[] args) {
    //create a board of 9X12 units
    Filler f = new Filler(9,12);
    //solve starting from the 0,0 position
    f.solve(0,0);
  }
}
