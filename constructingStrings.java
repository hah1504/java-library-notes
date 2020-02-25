

class constructingStrings {
  public static void main(String[] args) {
    char c[] = {'J', 'a', 'v', 'a'};
    String s1 = new String(c);
    String s2 = new String(s1);
    String s3 = new String(c, 1, 2);

    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
  }
}