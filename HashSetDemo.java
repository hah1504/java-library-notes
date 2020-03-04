// Demonstrate HashSet. 
import java.util.*; 
 
class HashSetDemo { 
  public static void main(String args[]) { 
    // Create a hash set. 
    HashSet<String> hs = new HashSet<String>(); 
     
    // Add elements to the hash set. 
    hs.add("Beta"); 
    hs.add("Alpha"); 
    hs.add("Eta"); 
    hs.add("Gamma"); 
    hs.add("Epsilon");
    hs.add("Omega");   

    System.out.println(hs); 
    System.out.println("HashSet Constians Alpha: "+hs.contains("Alpha")); 
    System.out.println("HashSet Constians Amit: "+hs.contains("Amit")); 
    hs.remove("Alpha");
    System.out.println("HashSet Constians Alpha: "+hs.contains("Alpha"));
    
    

    // Iterating over hash set items, order may not be same as when added
    System.out.println("Iterating over list:"); 
    Iterator<String> i = hs.iterator(); 
    while (i.hasNext()) 
        System.out.println(i.next()); 
  } 
}