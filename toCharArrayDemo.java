

class toCharArrayDemo {
  public static void main(String[] args) {
    String name = "Amit Kumar";

    char charName[] = name.toCharArray();
    for(char c: charName) {
      System.out.println(c+" ");
    }
  }
}