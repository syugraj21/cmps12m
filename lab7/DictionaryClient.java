// DictionaryClient.java
// Client module for testing Dictionary ADT

public class DictionaryClient{

   public static void main(String[] args){
      int v;
      Dictionary D = new Dictionary();

      D.insert(4, 35);
      D.insert(2, 32);
      D.insert(6, 17);
      D.insert(5, 44);
      D.insert(1, 41);
      D.insert(7, 79);
      D.insert(3, 64);
      
      System.out.println(D);

      v = D.lookup(1);
      System.out.println("key=1 " + (v==Dictionary.UNDEF?"not found":("value="+v)) );
      v = D.lookup(3);
      System.out.println("key=3 " + (v==Dictionary.UNDEF?"not found":("value="+v)) );
      v = D.lookup(7);
      System.out.println("key=7 " + (v==Dictionary.UNDEF?"not found":("value="+v)) );
      v = D.lookup(8);
      System.out.println("key=8 " + (v==Dictionary.UNDEF?"not found":("value="+v)) );
      System.out.println();

      // D.insert(2,32);  // causes KeyCollisionException

      D.delete(1);
      D.delete(3);
      D.delete(7);
      System.out.println(D);

      // D.delete(8);  // causes KeyNotFoundException

      System.out.println(D.isEmpty());
      System.out.println(D.size());
      D.makeEmpty();
      System.out.println(D.isEmpty());
      System.out.println(D);

   }
}