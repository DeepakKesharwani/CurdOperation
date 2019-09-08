package jamocha;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.lang.ClassNotFoundException;
	import java.util.*;

//import com.sun.org.apache.xerces.internal.impl.dv.dtd.StringDatatypeValidator;

	import jamocha.DateValidator;
	import jamocha.StringValidator;
	import jamocha.Emp;

	public class Employee {

		Connection con;
		PreparedStatement pstmt;
		ResultSet res;
		String fname;
		String lname;
		String age;
		String slry;
		String dpmt;
		String dob;
		int    i;
		String url = "jdbc:mysql://localhost:3306/Jamocha";
		String user="root";
		String password="1234";

		Scanner scan=new Scanner(System.in);
		StringValidator sv=new StringValidator();

		public  void viewAll() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url,user,password);
				pstmt = con.prepareStatement("select * from employee_details");
				res = pstmt.executeQuery();
				System.out.printf("%-5s %-30s %-30s %-5s %-10s %-15s %-10s", "ID", "First Name", "Last Name", "AGE",
						"Salary", "Department", "DOB");
				System.out.println();
				while (res.next() == true) {
					int a = res.getInt(1);
					String b = res.getString(2);
					String c = res.getString(3);
					String d = res.getString(4);
					String f = res.getString(5);
					String g = res.getString(6);
					String h = res.getString(7);
					System.out.printf("%-5s %-30s %-30s %-5s %-10s %-15s %-10s", a, b, c, d, f, g, h);
					System.out.println();
				}
				Emp.view();

			} catch (SQLException |ClassNotFoundException e) {
				
				e.printStackTrace();
			}	
			
		}



		public void addNew() {
			System.out.println("Enter First Name");
			while(true)
			{
			fname=scan.next();
			boolean rs=sv.stringValidator(fname);
			if(rs== true)
			{
				break;
			}
			else
			{
				System.out.println("Enter valid input");
			}
			}
			System.out.println("Enter Last Name");
			
			while(true)
			{
			lname=scan.next();
			boolean rs=sv.stringValidator(lname);
			if(rs== true)
			{
				break;
			}
			else
			{
				System.out.println("Enter valid input");
				
			}
			}
			System.out.println("Enter Age (Age should be in 2 figures)");
			
			while(true)
			{
					age =scan.next();
					if ( age.length()==2)
					{
						boolean rs = sv.ageValidator(age);
						if(rs==true)
						{
							break;
						}
						else
						{
							System.out.println("Enter valid input");
						}
					}
					
					else {
						System.out.println("Enter valid input");
					}
			}
			System.out.println("Enter Salary (5 figures)");
			while(true)
			{
					slry =scan.next();
					if ( slry.length()==5)
					{
						boolean rs = sv.ageValidator(slry);
						if(rs==true)
						{
							break;
						}
						else
						{
							System.out.println("Enter valid input");
						}
					}
					
					else {
						System.out.println("Enter valid input");
					}
			}
			System.out.println("Enter Department (CS,IT,EC) ");
			while(true)
	{
				dpmt=scan.next();
				if(dpmt.equalsIgnoreCase("CS") || dpmt.equalsIgnoreCase("IT") || dpmt.equalsIgnoreCase("EC"))
				{
					break;
				}
				else {
					System.out.println("Enter valid details");
				}
	}
			System.out.println("Enter Date of Birth (DD-MM-YYYY)");
			while(true)
			{
				dob=scan.next();
				DateValidator dv = new DateValidator();
				boolean r = dv.isThisDateValid(dob);
				if (r == true) {
					break;
				}
				else {
					System.out.println("Enter valid details");
				}
				
			}
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url,user,password);
				pstmt = con.prepareStatement("insert into employee_details(first_name,last_name,age,salary,department,dob) values (?,?,?,?,?,?)");
				pstmt.setString(1,fname);
				pstmt.setString(2,lname);
				pstmt.setString(3,age);
				pstmt.setString(4,slry);
				pstmt.setString(5,dpmt);
				pstmt.setString(6,dob);
				pstmt.executeUpdate();

				System.out.println("Data Inserted Successfully");
				Emp.view();
			} 

			catch (SQLException | ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			

	}


		public void modify() {
		
			System.out.println("Enter ID");
			while(true)
			{
			String id=scan.next();
			boolean temp=sv.idValidator(id);
			if(temp==true) {
				System.out.println("tg");
					i=Integer.parseInt(id);
					break;
			}
			else {
				System.out.println("Enter valid Id");
				
			}
			}
			
			System.out.println("Enter First Name");
			while(true)
			{
			fname=scan.next();
			boolean rs=sv.stringValidator(fname);
			if(rs== true)
			{
				break;
			}
			else
			{
				System.out.println("Enter valid input");
			}
			}
			System.out.println("Enter Last Name");
			
			while(true)
			{
			lname=scan.next();
			boolean rs=sv.stringValidator(lname);
			if(rs== true)
			{
				break;
			}
			else
			{
				System.out.println("Enter valid input");
				
			}
			}
			System.out.println("Enter Age (Age should be in 2 figures)");
			
			while(true)
			{
					age =scan.next();
					if ( age.length()==2)
					{
						boolean rs = sv.ageValidator(age);
						if(rs==true)
						{
							break;
						}
						else
						{
							System.out.println("Enter valid input");
						}
					}
					
					else {
						System.out.println("Enter valid input");
					}
			}
			System.out.println("Enter Salary (5 figures)");
			while(true)
			{
					slry =scan.next();
					if ( slry.length()==5)
					{
						boolean rs = sv.ageValidator(slry);
						if(rs==true)
						{
							break;
						}
						else
						{
							System.out.println("Enter valid input");
						}
					}
					
					else {
						System.out.println("Enter valid input");
					}
			}
			System.out.println("Enter Department (CS,IT,EC) ");
			while(true)
			{
				dpmt=scan.next();
				if(dpmt.equalsIgnoreCase("CS") || dpmt.equalsIgnoreCase("IT") || dpmt.equalsIgnoreCase("EC"))
				{
					break;
				}
				else {
					System.out.println("Enter valid details");
				}
			}
			System.out.println("Enter Date of Birth (DD-MM-YYYY)");
			while(true)
			{
				dob=scan.next();
				DateValidator dv = new DateValidator();
				boolean r = dv.isThisDateValid(dob);
				if (r == true) {
					break;
				}
				else {
					System.out.println("Enter valid details");
				}
				
			}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url,user,password);

					pstmt = con.prepareStatement("update employee_details set first_name=?,last_name=?,age=?,salary=?,department=?,dob=? WHERE employee_id=?");
				
				pstmt.setString(1,fname);
				pstmt.setString(2,lname);
				pstmt.setString(3,age);
				pstmt.setString(4,slry);
				pstmt.setString(5,dpmt);
				pstmt.setString(6,dob);
				pstmt.setInt(7, i);
				pstmt.executeUpdate();
				}
				catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Data Inserted Successfully");
				Emp.view();
			
		}



		public void delete() {
			System.out.println("Enter id");
			try {
				int id=scan.nextInt();
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url,user,password);
				pstmt = con.prepareStatement("delete from employee_details where employee_id=?");
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				System.out.println("Deletion Successfully");
			}
			catch(SQLException |ClassNotFoundException e) {
				e.printStackTrace();
				
			}
			catch(Exception e) {
				System.out.println("Enter valid inputs");
				delete();
			}
			Emp.view();
		}



		public void exit() {
			System.out.println("Thank you");
			
		}

	}


