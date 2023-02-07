package com.java;

import java.sql.SQLException;
import java.util.ArrayList;

public class MyProgram {

	public static void main(String[] args) 
	{
        Student s = new Student();
        
       // s.creating();
        
         
        
			//s.inserting("Ram", "java", "ram@gmail.com");
			//s.inserting("Ajay", "python", "aj@gmail.com");
			//s.inserting("Karan", "SQL", "karan@gmail.com");
        	//s.Updating(2, "ak@gmail.com", "java");
        	//s.deleting(1);
        	//s.read();
        
        ArrayList<Student1> res = Student.reading();
        for(Student1 i: res)
        {
        	System.out.println(i.getId());
        	System.out.println(i.getName());
        	System.out.println(i.getSub());
        	System.out.println(i.getMail());
        	
        	System.out.println("****************************");
        }
			
		
	}

}
