/*Yugraj Singh 
 *This program is built off of ArrayDoubling in class, and implents generics 
 * 
 */ 
class List<T> implements ListInterface<T>{
    //private fields
    private static final int INITIAL_SIZE = 1;
    private int sizeOfArray;
    private T[] item;
    private int numItems;
    //actual position in array
    private int arrayIndex(int listIndex){
     return listIndex-1; 
    }
    /*arrayDouble
     * Pos: doubles the size of the array
     */
    @SuppressWarnings("unchecked")
    private void doubleArray(){
      sizeOfArray *=2;
      T[] newArray = (T[])new Object[sizeOfArray];
      for( int i=0; i<numItems;i++){
        newArray[i]=item[i];
      }
      item = newArray;
    }
    
    //constructor for the list class
    @SuppressWarnings("unchecked")
    public List(){
      sizeOfArray = INITIAL_SIZE;
      item = (T[])new Object[sizeOfArray];
      numItems = 0;
    }
    /*isEmpty
     * Pos: returns false if the list is empty and true if it isnt 
     */ 
    public boolean isEmpty(){
      return (numItems==0);
    }
    //returns the size of the list
    public int size(){
      return numItems;
    }
    /*get
     *Pre: has to be in the bounds of the list 
     *Pos: returns the value at the position indicated by the index
     */ 
    public T get(int index) throws ListIndexOutOfBoundsException{
      if( index<1 || index>(numItems+1)){
        throw new ListIndexOutOfBoundsException("get() index not in the bounds of the list"); 
      }
      return item[arrayIndex(index)]; 
    }
    /*add
     *Pre: index<1 || index>(numItems+1) 
     *Pos: adds an element to the list 
     */
    public void add(int index, T newItem) throws ListIndexOutOfBoundsException{
      if(index<1 || index>(numItems+1)){
        throw new ListIndexOutOfBoundsException("add() index not in the bounds of the list");
      }
      if( numItems==sizeOfArray){
        doubleArray();
      }
      for(int i = numItems; i>=index; i--){
        item[arrayIndex(i+1)] = item[arrayIndex(i)];
      }
      item[arrayIndex(index)] = newItem;
      numItems++;
    }
     /*remove
     *Pre: index<1 || index>(numItems+1) 
     *Pos: removes an element from the list 
     */
    public void remove(int index) throws ListIndexOutOfBoundsException{
      if(index<1 || index>(numItems+1)){
        throw new ListIndexOutOfBoundsException("remove() index not in the bounds of the list");
      }
      for(int i=index+1; i<=numItems;i++){
        item[arrayIndex(i-1)] = item[arrayIndex(i)];
      }
      numItems--;
    }
    
    public void removeAll(){
      numItems=0;
    }
    /*toString
     *puts the list into a string 
     */
    public String toString(){
      String s="";
      for(int i=0; i<numItems;i++){
        s += item[i]+ " ";
      }
      return s;
    }
    /*equals
     *Pos: returns true or false if the contents of the list equal on another list 
     */ 
    @SuppressWarnings("unchecked")
    public boolean equals(Object rhs){
      boolean eq =false;
      List<T> R = null;
      
      if(this.getClass() == rhs.getClass()){
        int i=0;
        R = (List<T>) rhs;
        eq = (this.numItems == R.numItems);
        while( eq && i<numItems){
          eq = (this.item[i] == R.item[i]);
          i++;
        }
      }
      return eq;
    }
}
    
          
    
    
    
      
    
  
  
  
