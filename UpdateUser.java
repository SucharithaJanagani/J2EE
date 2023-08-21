package org.jsp;
		import java.sql.Connection;
        import java.sql.DriverManager;
		import java.sql.SQLException;
		import java.sql.Statement;
		public class UpdateUser {
		     public static void main(String[] args) {
		    	 Connection con=null;
		    	 Statement st=null;
		    	 String url,user,password;
		    	 url="jdbc:mysql://localhost:3306/jdbc_demo";
		    	 user="root";
		    	 password="admin";
		    	 String query="update user set name='Samantha',phone=222 where id=3";
		    	 try {
		    		 Class.forName("com.mysql.cj.jdbc.Driver");
		    		 con=DriverManager.getConnection(url,user,password);
		    		 st=con.createStatement();
		    		int r=st.executeUpdate(query);
		    		 System.out.println(r+"rows are updated");
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




	


