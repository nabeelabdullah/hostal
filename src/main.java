
import java.util.*;

public class main {
    
static dataabase senddatabase()
        {
            dataabase b1 = null;
            if(b1==null)
            { dataabase b = new dataabase();
              b1=b;
            }
        return b1;
        }
    public static void main(String[] nabeel) {
        
        
        
        student s = new student();
        admin a = new admin();
        int q = 1;
        while (q == 1) {
            System.out.println(" 1-> for student, 2-> for admin");

            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    s.inter();
                    break;
                case 2:

                    int ad = a.admincheck(),
                     cls = 1;
                    if (ad == 1) {
                        while (cls == 1) {
                            System.out.print("1-allot,2-deallot,3-check, 4-new room record enter,5-close -> ");
                            Scanner sc3 = new Scanner(System.in);
                            int ck = sc3.nextInt();
                            if (ck == 1) {
                                a.allot();
                            }
                            if (ck == 2) {
                                a.deallot();
                            }
                            if (ck == 3) {
                                
                                System.out.println("BY NAME PRESS 1->");
                                System.out.println("BY ROLL PRESS 2->");
                                System.out.println("BY ROOM PRESS 3->");
                                int k = sc.nextInt();
                                String A=null;
                                String B=null;
                                if(k==1)
                                {  System.out.println("ENTER NAME -> ");
                                Scanner sc1=new Scanner(System.in);
                                  B=sc1.nextLine();
                                  A="name";
                                }
                                if(k==2)
                                {  System.out.println("ENTER ROLL -> ");
                                Scanner sc1=new Scanner(System.in);
                                  B=sc1.nextLine();
                                  A="r_no";
                                }
                                if(k==3)
                                {  System.out.println("ENTER ROOM -> ");
                                Scanner sc1=new Scanner(System.in);
                                  B=sc1.nextLine();
                                  A="room";
                                }
                                a.studentrecord(B,A);
                            }
                            if (ck == 5) {
                                cls = 0;
                            }
                            if (ck == 4) {
                                a.roomrecord();
                            }

                        }
                    } else {
                        System.out.println("wrong admin");
                    }
                    break;
                default:
                    System.out.println("invalid selection");
            }
        }
    }
}
