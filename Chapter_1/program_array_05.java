import java.util.*;
public class program_array_05 {
    public static void main(String args[])
    {
        //array declaration
        String frinends[] = new String[5];
        //inserting data in array by index
        frinends[0]="Komal";
        frinends[1]="Mahi";
        frinends[2]="kamini";
        frinends[3]="Kiran";
        frinends[4]="Shweta";
        //display array elements
        for(String val:frinends){
            System.out.println(val);
        }

    }
}
