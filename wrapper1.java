
// See difference between Double.valueOf and Double.parseDouble


class wrapper1 {
  public static void main(String[] args) {
    double n1 = 88.90;
    String n2 = "90.34";

    System.out.println();
    Float f1 = Float.valueOf(n2);
    System.out.println("f1="+f1);

    Double d1 = Double.valueOf(n2);
    System.out.println("d1="+d1);

    Double d2 = Double.parseDouble(n2);
    System.out.println("d2="+d2);
    Double d3 = Double.valueOf(n1); //allows both String and Double values
    // Double d4 = Double.parseDouble(n1); //error


    // constants
    System.out.println("TYPE: " + f1.TYPE);
    System.out.println("TYPE: " + d1.TYPE);
    System.out.println("SIZE: " + f1.SIZE);
    System.out.println("SIZE: " + d1.SIZE);
    System.out.println("NaN: " + f1.NaN);


    // Float Methods
    System.out.println(Float.toHexString(f1));
    System.out.println(f1.intValue());
    System.out.println(f1.isInfinite());
    System.out.println(f1.intValue());

  }
}