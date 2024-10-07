//package chapter_3;
import java.util.*;
public class Program_java_02 {
  //ArrayList
  public static void main(String args[]){

    ArrayList<String> nameList = new ArrayList<>(); //store only String type of elements
    //adding elements
    nameList.add("Komal");
    nameList.add("Mahi");
    nameList.add("Pooja");
    nameList.add(1,"Vaishu");
    
    //print list
    System.out.println(nameList);
  }  
}
