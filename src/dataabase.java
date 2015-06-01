 import java.sql.*;
 class dataabase 
 {
   Statement stat;
   ResultSet p;
   Statement coll()
   { return stat;
   }
   dataabase()
   { connection();
 
   }
 void connection()
   {
         try{
            Class.forName("com.mysql.jdbc.Driver");             
            }   
          
         catch(ClassNotFoundException cnf){}
         String url="jdbc:mysql://127.0.0.1:3306/hostel";
         String user="root";
         String pass ="admin";
        
         try{
         Connection con=DriverManager.getConnection(url,user,pass);
         stat=con.createStatement();
            }
         catch(SQLException sqle){}
      
 }
         
     ResultSet read(String q)
       {  
        try{
          
             p=stat.executeQuery(q);
                }
             catch(SQLException sqle)
                 
             {
                 sqle.fillInStackTrace();
             }
            return p;
       }
       
       void towrite(String q)
          {
              
           try 
           {
              
            
             stat.execute(q);
 
           }
       catch(SQLException sqle)
       { 
          
       }    
   
          }
          }
    
    
    
    
    
    
    
    
    
    

