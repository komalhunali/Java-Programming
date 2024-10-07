import java.util.*;
public class program_array_05 {
    public static void main(String args[])
    {
        //array declaration
        String frinends[] = new String[5];
        //inserting data in array by index
        frinends[0]="komal";
        frinends[1]="mahi";
        frinends[2]="kamini";
        frinends[3]="kiran";
        frinends[4]="shweta";
        //display array elements
        for(String val:frinends){
            System.out.println(val);
        }

    }
}
