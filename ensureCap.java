


class ensureCap {
  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer("Hello");
    sb.ensureCapacity(25);  //44 = (16+5)*2 + 2

    System.out.println(sb);
    System.out.println("length: "+sb.length());
    System.out.println("capacity: "+sb.capacity());
  }
}


/**
 * Notes
 * - The ensureCapacity() method of StringBuffer class ensures the capacity to at least equal to the specified minimumCapacity.
 *  - If the current capacity of StringBuffer < the argument minimumCapacity, then a new internal array is allocated with greater capacity.
 *  - If the minimumCapacity argument > twice the old capacity, plus 2 then new capacity is equal to minimumCapacity else new capacity is equal to twice the old capacity, plus 2.  
 *  - If the minimumCapacity argument passed as parameter < 0, this method takes no action.
 * 
 */