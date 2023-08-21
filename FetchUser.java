package org.jsp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class FetchUser {
	public static void main(String[] args) {
		    	 Connection con=null;
		    	 Statement st=null;
		    	 ResultSet rs=null;
		    try {
		    		 Class.forName("com.mysql.cj.jdbc.Driver");
		    		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","admin");
		    		 st=con.createStatement();
		    		 rs=st.executeQuery("select * from user");
		    		 while(rs.next())
		    		 {
		    			 System.out.println(rs.getInt("id")+" "+rs.getString(2)+" "+rs.getLong(3));
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
		    			 if(st!=null)
		    			 {
		    				 try
		    				 {
		    					 st.close();
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











