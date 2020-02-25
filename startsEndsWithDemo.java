


class startsEndsWithDemo {
  public static void main(String[] args) {
    String s1 = "My Name is Amit";
    String s2 = "Amit is a programmer";

    System.out.println(s1 + ". Ends with Amit?: " + s1.endsWith("Amit"));
    System.out.println(s1 + ". Ends with Kumar?: " + s1.endsWith("Kumar"));
    System.out.println(s2 + ". Starts with Amit?: " + s1.startsWith("Amit"));
    System.out.println(s2 + ". Starts with Kumar?: " + s1.startsWith("Kumar"));
  }
}