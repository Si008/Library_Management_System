package Librarymanagementsystem;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.Scanner;

public class UserDAO {

          public void newUser(){
              Scanner inp = new Scanner(System.in);
              String query = "insert into user  (Name,Dept,ph_no,Type,std_id,tea_id) values (?,?,?,?,?,?);";
                try{
                    Connection conn = DBconnection.getConnection();
                    PreparedStatement ps = conn.prepareStatement(query);
                    System.out.println("Enter the name :");
                    ps.setString(1,inp.nextLine());

                    System.out.println("Enter the Dept name :");
                    ps.setString(2,inp.nextLine());

                    System.out.println("Enter the Phone num  :");
                    ps.setString(3,inp.nextLine());

                    System.out.println("Enter the Type of user (Student/Teacher):");
                    String s = inp.next();
                    ps.setString(4,s);
                    if(s.equalsIgnoreCase("student")) {
                        System.out.println("Enter the std_id :");
                        ps.setInt(5, inp.nextInt());
                        ps.setNull(6, java.sql.Types.INTEGER);

                    }
                    else {
                        System.out.println("Enter the tea_id :");
                        ps.setNull(5, java.sql.Types.INTEGER );
                        ps.setInt(6, inp.nextInt());
                    }
                    int rows =  ps.executeUpdate();
                    System.out.println(" User inserted to database of type " + s  + " and rows affected " + rows );
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
          }
          public User getUser(String name){
              User user = null ;
              String query = "select * from user where Name = ?" ;
              String s1  = "Student";
              String s2  = "Teacher";
              try
              {
                  Connection conn = DBconnection.getConnection();
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1,name.trim());
                  ResultSet rs = ps.executeQuery();

                  while(rs.next()){

                      String usertype = rs.getString("type");
                      if(usertype.equalsIgnoreCase(s1)){
                          user = new Student(
                                  rs.getString("name"),
                                  rs.getString("Dept"),
                                  rs.getString("ph_no"),
                                  rs.getString("Std_id"));

                      }
                      else if(usertype.equalsIgnoreCase(s2)) {
                          user = new Teacher(
                                  rs.getString("name"),
                                  rs.getString("Dept"),
                                  rs.getString("ph_no"),
                                  rs.getString("tea_id"));

                      }
                      if(user!= null){
                          System.out.println("DB row "+rs.getInt("id"));
                          user.displayUser();

                          System.out.println("---------");
                      }
                      else
                          System.out.println("There is no user in DB");
                  }


              }
              catch(SQLException e){
                  e.printStackTrace();
              }
            return user ;
          }
}
