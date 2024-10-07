//stack
import java.util.*;
public class Program_java_13 {
    public static void main(String args[]){
        //stack 
        Stack<String> st = new Stack<>();
        //adding elements
        st.push("Praju");
        st.push("Komal");
        st.push("Shraddha");
        st.push("Jannat");

        System.out.println("Elements in stack: "+st);
        //removing elements vrashali
        st.pop();

        System.out.println(st);
        
        System.out.println(st.peek());//returns element on top
    }
}
