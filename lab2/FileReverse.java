/*Yugraj Singh W1234081
 *FileReverse.java
 *
 *This program is built off of Token example given in by the professor,
 *and the program takes two command line args to read the input from a
 *file and print the words backward in the output file
 *
 */

import java.io.*;
import java.util.Scanner;

public class FileReverse{
  public static void main(String[] args) throws IOException{
    Scanner input = null;
    PrintWriter out = null;
    String line = null;
    String[] token = null;
    int n;
    
    //throws an exception if less then two args are given
    if(args.length < 2){
      System.err.println("Usage: FileReverse infile outfile");
      System.exit(1);
    }
    //assigns the command line args
    input = new Scanner(new File(args[0]));
    out = new PrintWriter(new FileWriter(args[1]));
    
  
    //loop that run as long a its reading input from the file
    input.useDelimiter("\n");
    while(input.hasNext()){
      line = input.next() +" ";//assigns the input from file into a string
      token = line.split("\\s+");//splits the words in the line
      for(int i=0; i<token.length; i++){
        n = token[i].length();
        out.println(stringReverse(token[i],n));
      }         
    }
    input.close();
    out.close();
  }

  //stringReverse
  //Pre: takes a string and an int n( note: n must be the length of the string)
  //Pos: returns the string spelled backwards
  public static String stringReverse(String s, int n){
    if(n>0){
      return  s.charAt(n-1) + stringReverse(s,n-1); 
    }  
    return "";   
  }
}









