/*Yugraj Singh
 *Dictionary ADT of Binary Search Tree
 *This Program creates Binary Search Tree ADT in Java
 */ 
public class Dictionary implements DictionaryInterface{
  //inner private class which constructs the ADT 
  private class Node{
    int key;
    int value;
    Node left;
    Node right;
    //private class constructor
    Node(int key, int value){
      this.key = key;
      this.value = value;
      left = null;
      right = null;
    }
  }
  /*findkey
   *Pre:takes Node N, and int key 
   *Pos:returns the reference to N which holds the key, if
   *    none is found, findKey return null;
   */ 
  private Node findKey(Node N, int k){
    if ( N == null || k == N.key ){
      return N;
    }
    if( k < N.key){
      return findKey(N.left,k);
    }
    else{
      return findKey(N.right,k);
    }
  }
  /*findParent
   *Pre: takes two Node references  
   *Pos: returns the parent of the Nodes 
   */ 
  private Node findParent(Node N, Node R){
    Node P = null;
    if( N != R ){
      P = R;
      for(; P.left!=N && P.right!=N; P=(N.key<P.key? P.left:P.right)){
      }
    }
    return P;
  }
  /*fineLeftMost
   *Pre: takes a Node N 
   *Pos: returns the reference to the left most leef/node  
   */ 
  private Node findLeftMost(Node N){
    Node L = N;
    if( L!= null){
      for(; L.left!=null; L = L.left){
      }
    }
    return L;
  }
  /*printInOrder
   *Pre:takes a Node N 
   *Pos:puts the keys in increasing numeric order into a string 
   */ 
  private String printInOrder(Node N){
    String s ="";
    if( N!=null){ 
      s = printInOrder(N.left) + N.key + " " + N.value + "\n" +printInOrder(N.right);
    }
    return s;
  }
  //private root and numpairs
  private Node root;
  private int numPairs;
  // Dictionary constructor
  Dictionary(){
    root = null;
    numPairs = 0;
  }
  /*isEmpty
   *Pre:none
   *Pos:returns true or false 
   */ 
  public boolean isEmpty(){
    return (numPairs == 0);
  }
  
  /*size
   *Pre: none
   *Pos: return the size of the ADT
   */
  public int size(){
    return numPairs;
  }
  /*lookup
   *Pre:none 
   *Pos:returns the value associated with int k(the key) or UNDEF 
   */ 
  public int lookup(int k){
    Node N = findKey(root,k);
    if (N!=null){
      return N.value;
    }
    else{
      return UNDEF;
    }
  }
  /*insert
   *Pre:int k must not already be in the ADT 
   *Pos: adds int k and v into the ADT 
   */
  public void insert(int k, int v) throws KeyCollisionException{
    Node N, A, B;
    if ( findKey(root,k) != null){
      throw new KeyCollisionException("Cannot insert() duplicate keys");
    }
    N = new Node(k,v);
    B = null;
    A = root;
    
    while( A != null){
      B = A;
      if( k < A.key){
        A = A.left;
      }
      else{
        A = A.right;
      }
    }
    if( B == null){
      root = N;
    }
    else if( k< B.key){
      B.left = N;
    }
    else{
      B.right = N;
    }
    numPairs++;
  }
  
  /*delete
   *Pre: int k must be in the dictionary ADT 
   *Pos: deletes the key and values associated with k from the ADT 
   */ 
  public void delete(int k) throws KeyNotFoundException{
    Node N, P, S;
    N = findKey(root,k);
    if( N == null){
      throw new KeyNotFoundException("Cannot delete() non-existant key");
    }
    if( N.left == null && N.right == null){
      if(N == root){
        root = null;
      }
      else{
        P = findParent(N,root);
        if ( P.right == N){
          P.right = null;
        }
        else{
          P.left = null;
        }
      } 
    }
    else if( N.right == null){
      if ( N == root){
        root = null;
      }
      else{
        P = findParent(N,root);
        if ( P.right == N){
          P.right = N.left;
        }
        else{
          P.left = N.left;
        }
      }
    }
    else if( N.left == null){
      if( N == root){
        root = null;
      }
      else{
        P = findParent(N,root);
        if(P.right == N){
          P.right = N.right;
        }
        else{
          P.left = N.right;
        }
      }
    }
    else{
      S = findLeftMost(N.right);
      N.key = S.key;
      N.value = S.value;
      P = findParent(S,N);
      if(P.right == S){
        P.right = S.right;
      }
      else{
        P.left = S.right;
      }
    }
    numPairs--;
  }
  /*makeEmpty
   *Pre: none 
   *Pos: sets root to null and numPairs to 0 
   */ 
  public void makeEmpty(){
    root = null;
    numPairs = 0;
  }
  /*toString
   *Pre:none 
   *Pos:overides the Object toString method 
   */ 
  public String toString(){
    String s = printInOrder(root);
    return  s; 
  }
  
}





