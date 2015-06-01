/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SHAHNOOR41
 */
public class NewClass {
    
    
   public static void main(String[] as)
    {    dataabase b= new dataabase();
              int k=37
                     ;
        for(int i=0;i<6;i++)
        {  for(int j=1;j<=4;j++)
        { 
            
            String S="insert into student values('"+k+"','"+j+"','nabeeel"+k+"','it','0','"+(j-1)+"')" ;
            System.out.println(S);
                   b.towrite(S);
                   k++;
        }
        }
    }
    
}
