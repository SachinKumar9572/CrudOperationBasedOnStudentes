package com.java;

import java.sql.*;
import java.util.ArrayList;

public class Student 
{

	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	
	private static ResultSet rs = null;
	private static String url = "jdbc:mysql://localhost:3306/palle";
	private static String username = "root";
	private static String password = "admin";
	
	public void creating()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
			s= con.createStatement();
			
			s.executeUpdate("create table student(sno int primary key auto_increment, sname varchar(40),sub varchar(40),email varchar(60)unique)");
			
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		finally
		{
			if(s != null) 
			{
				try 
				{
					s.close();
				} 
				catch (SQLException e) 
				{
				
					e.printStackTrace();
				}
			}
			if(con != null) 
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
				
					e.printStackTrace();
				}
			}
	}
		}
	
	public void inserting(String name, String sub, String mail) throws ClassNotFoundException, SQLException
	{

    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
        con = DriverManager.getConnection(url,username,password);
        
        ps= con.prepareStatement("insert into student(sname,sub,email) values(?,?,?)");
        ps.setString(1, name);
        ps.setString(2, sub);
        ps.setString(3, mail);
        ps.executeUpdate();
        
        ps.close();
        con.close();
        	
	}
	
	public void Updating(int id, String mail, String sub) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
    	
	    con = DriverManager.getConnection(url,username,password);
	    ps = con.prepareStatement("update student set sub=?, email=? where sno=?");
	    
		ps.setString(1, sub);
		ps.setString(2, mail);
		ps.setInt(3,id);
		ps.executeUpdate();
		
		
		ps.close();
        con.close();
	}
	
	public void deleting(int id) throws ClassNotFoundException, SQLException
	{
         Class.forName("com.mysql.cj.jdbc.Driver");
    	
	    con = DriverManager.getConnection(url,username,password);
	     ps=con.prepareStatement("delete from student where sno=?");
	     ps.setInt(1, id);
	     ps.executeUpdate();
	     
	     ps.close();
	     con.close();
	}
	
	public void read()
	{
       try 
       {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		String qry= "select * from student";
		s = con.createStatement();
		rs = s.executeQuery(qry);
		
		while(rs.next())
		{
			System.out.println(rs.getInt("sno"));
			System.out.println(rs.getString("sname"));
			System.out.println(rs.getString("sub"));
			System.out.println(rs.getString("email"));
			System.out.println("************************");
		}
		
	   }
       catch (ClassNotFoundException e) 
       {
		
		e.printStackTrace();
	} 
       catch (SQLException e) 
       {
		
		e.printStackTrace();
	}
    	
	    
	}
	
	public static ArrayList<Student1>reading()
	{
		ArrayList<Student1>alStud = new ArrayList<Student1>();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			s = con.createStatement();
			rs = s.executeQuery("select * from student");
			while(rs.next())
			{
				int id = rs.getInt("sno");
				String name = rs.getString("sname");
				String sub = rs.getString("sub");
				String mail = rs.getString("email");
				
				Student1 st = new Student1(id,name,mail);
				alStud.add(st);
			}
			
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally {
			  
			  try 
			  {
				  if(rs!=null)
				  {
					  rs.close();  
				  }
				if(s!=null)
				{
					s.close();
				}
				if(con != null)
				{
			    con.close();
				}
			} 
			  catch (SQLException e) 
			  {
				
				e.printStackTrace();
			  }
		}
		return alStud;
	}
}
