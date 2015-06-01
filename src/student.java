
import java.util.Scanner;
import java.sql.*;

public class student 
{
    main m;
    dataabase b=m.senddatabase();

    void inter()
       {
    System.out.print("enter your r_no               -> ");
    Scanner sc=new Scanner(System.in);
    String p=sc.nextLine();
    System.out.print("enter your name               -> ");
    String q=sc.nextLine();
    System.out.print("enter your year               ->");
    String r=sc.nextLine();
    System.out.print("enter your branch             -> ");
    String s=sc.nextLine();
    System.out.print("how much seater do you like   ->");
    int c=sc.nextInt();
    String m="insert into student values (" +"'"+p+"',"+"'"+r+"',"+"'"+q+"',"+"'"+s+"','0',"+c+");";
   
     b.towrite(m);
       
      
    }
    
    
}
