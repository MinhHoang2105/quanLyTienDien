package test;

import java.sql.*;

public class ConnectDB {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/quanlytiendien";

   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT id, name, age FROM employee";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         int id  = rs.getInt("id");
         String name = rs.getString("name");
         int age = rs.getInt("age");

         System.out.print("ID: " + id);
         System.out.print(", Name: " + name);
         System.out.println(", Age: " + age);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("Goodbye!");
}
}

