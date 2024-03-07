package com.app.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuerry {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pranay");
			st=con.createStatement();
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
			
			System.out.print("Enter the Employee ID:");
			int eid=Integer.parseInt(br.readLine());
			
			System.out.print("Enter the Employee Name:");
			String ename=br.readLine();
			
			System.out.print("Enter the Employee Salary:");
			float esal=Float.parseFloat(br.readLine());
			
			System.out.print("Enter the Employee Address:");
			String eaddr=br.readLine();
			
			st.executeUpdate("insert into soft values ("+eid+",'"+ename+"',"+esal+",'"+eaddr+"')");
			
			System.out.println("Querey Execute Successfully");
			System.out.println("employee Data Insert Successfully");
			System.out.println("If you Enter More Data :YES/NO :");
			String option=br.readLine();
			
			if(option.equalsIgnoreCase("NO"))
			{
				break;
			}
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				st.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}


	}

}

