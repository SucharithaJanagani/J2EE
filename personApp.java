package org.person;
import java.sql.DriverManager;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;
public class personApp {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.To Save");
		System.out.println("2. To Update");
		System.out.println("3.To Delete");
		System.out.println("4.To Fetch By Id");
		System.out.println("5.To Login");
		System.out.println("enter");
		int choice=sc.nextInt();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","admin");
			switch(choice){
			case 1:{
				pst=con.prepareStatement("insert into person values(?,?,?,?,?)");
				System.out.println("enter your id,name,age,phone,password");
				int id=sc.nextInt();
				String name=sc.next();
				int age=sc.nextInt();
				long phone=sc.nextLong();
				String password=sc.next();
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setInt(3,age);
				pst.setLong(4, phone);
				pst.setString(5,password);
				pst.executeUpdate();
				System.out.println("your details are registered successfully");
				break;
			}
			case 2:{
				pst=con.prepareStatement("update person set name=?,age=?,phone=?,password=? where id=?");
				System.out.println("Enter ur Existing id to update");
				int id=sc.nextInt();
				System.out.println("Enter ur name,age,phone and password to update");
				String name=sc.next();
				int age=sc.nextInt();
				long phone=sc.nextLong();
				String password=sc.next();
				pst.setInt(5, id);
				pst.setString(1, name);
				pst.setInt(2,age);
				pst.setLong(3, phone);
				pst.setString(4,password);
				pst.executeUpdate();
				System.out.println("your details are updated successfully");
				break;
			}
			case 3:{
				pst=con.prepareStatement("delete from person where id=?");
						System.out.println("Enter your ID to delete");
				int id=sc.nextInt();
				pst.setInt(1,id);
				int r=pst.executeUpdate();
				if(r==0)
					System.out.println("Invalid ID");
				else
					System.out.println("Deleted successfully");
				break;
			}
			case 4:{
				pst=con.prepareStatement("select *from person where id=?");
				System.out.println("Enter your ID to print the details");
				int id=sc.nextInt();
				pst.setInt(1, id);
				rs=pst.executeQuery();
				while(rs.next())
				{
					System.out.println("ID:"+rs.getInt(1));
					System.out.println("Name:"+rs.getString(2));
					System.out.println("age:"+rs.getInt(3));
					System.out.println("phone Number:"+rs.getLong(4));
					break;
				}
			}
				case 5:{
					System.out.println("Enter ur registered phone Number");
					long phone=sc.nextLong();
					System.out.println("Enter ur password");
					String ps=sc.next();
					pst=con.prepareStatement("select * from person where phone=?");
					pst.setLong(1,phone);
					pst.setString(2,ps);
					rs=pst.executeQuery();
					if(rs.next())
					{
						System.out.println("Login successfully");
						System.out.println("ID:"+rs.getInt(1));
						System.out.println("name:"+rs.getString(2));
						System.out.println("phone:"+rs.getLong(3));
						System.out.println("Age:"+rs.getInt(4));
					}
					else
						System.out.println("Invalid phone and password");
				}
			}
		}
				
			catch(ClassNotFoundException|SQLException e)
			 {
				 e.printStackTrace();
			 }
				 finally {
					 if(con!=null)
					 {
						 try {
							 con.close();
							 System.out.println("connection closed");
						 }
						 catch(SQLException e)
						 {
							 e.printStackTrace();
						 }
					 }
					 if(pst!=null)
					 {
						 try
						 {
							 pst.close();
							 System.out.println("statement closed");
						 }
						 catch(SQLException e)
						 {
							 e.printStackTrace();
						 }
					 }
					 if(rs!=null)
					 {
						 try
						 {
							 rs.close();
							 System.out.println("statement closed");
						 }
						 catch(SQLException e)
						 {
							 e.printStackTrace();
						 }
				 }
			 }
	}
}

		
			






				
			
			
				

			









			
				
		
			
		
		
	


