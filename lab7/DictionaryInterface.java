// DictionaryInterface.java
// interface for the Dictionary ADT

public interface DictionaryInterface{

   // UNDEF
   // constant that signifies an undefined value
   public static final int UNDEF = -1;

   // isEmpty()
   // pre: none
   // post: returns true if this Dictionary is empty, false otherwise
   public boolean isEmpty();

   // size()
   // pre: none
   // post: returns the number of entries in this Dictionary
   public int size();

   // lookup()
   // pre: none
   // post: returns value associated key k, or UNDEF if no such key exists
   public int lookup(int k);

   // insert()
   // inserts new (key,value) pair into this Dictionary
   // pre: key k does not exist in this Dictionary, i.e. lookup(k)==UNDEF
   // post: !isEmpty(), size() is increased by one
   public void insert(int k, int v) throws KeyCollisionException;

   // delete
   // deletes the pair with the key k
   // pre: key k currently exists in this Dictionary, i.e. lookup(k)!=UNDEF
   // post: size() is decreased by one
   public void delete(int k) throws KeyNotFoundException;

   // makeEmpty()
   // pre: none
   // post: isEmpty()
   public void makeEmpty();

   // toString()
   // overrides Object's toString() method
   // pre: none
   // post: returns a String representation of this Dictionary ordered
   // by ascending keys
   public String toString();
}