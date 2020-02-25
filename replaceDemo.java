


class replaceDemo {
  public static void main(String[] args) {
    //first form of replace
    String s1 = "Hello";
    String replacement1 = s1.replace('l', 'd');
    System.out.println(replacement1);

    //second form of replace
    String s2 = "My name is Subhash. It is a good day today!";
    String replacement2 = s2.replace("is", "was");
    System.out.println(replacement2);
  }
}