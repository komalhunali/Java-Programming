//package chapter_3;
import java.util.*;
public class Program_java_09 {
    public static void main(String args[]){
        LinkedList list = new LinkedList<>();
        
        list.add("Komal");
        list.add("Mahi");
        list.add("Vaishnavi");
        list.add("Maheshwari");
        list.add("Vedika");

        System.out.println(list);

        list.remove("varsha"); //remove varsha from list
        System.out.println(list);

        list.removeLast();  //remove last value from list
        System.out.println(list);
    }
}
