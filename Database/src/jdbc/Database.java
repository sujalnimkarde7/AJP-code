package jdbc;
import java.sql.*;
import java.util.*;

public class Database {
	Connection con;
	Derived Data;
	
	Database(){
		Data=new Derived();
		
	}
	
	public static void main(String args[]) throws Exception {
		Database obj=new Database();
      	obj.getConnect();
      	
      	Scanner sc=new Scanner(System.in);
      	int ch;
      	try {
      		do {
      			
      			System.out.println("\\n1.Create the table \\n2.Insert the data \\n3.Fetch Data \\n4.Delete Record \\n5.Update Record \\n6.Search Record \\n7.Close Connection");
      			System.out.println("Select the operation=");
      			int choice=sc.nextInt();
      			switch (choice) {
      			
      			case 1:obj.createtable();
      			       break;
      			case 2:obj.insertdata();
			           break;       
      			case 3:obj.fetchdata();
		               break;    
      			case 4:obj.deletedata();
      			       obj.fetchdata();
	                   break;  
      			case 5: obj.updatedata();
      			        obj.fetchdata();
      			       break;
      			 case 6:obj.searchdata();
      			        break;
      			case 7:obj.closeconnection();
		               break;       
      			default:System.out.println("Enter the correct option");
		                break;       
      			}
    			System.out.println("Do you want to continue then press 1 otherwise 0");
    			ch=sc.nextInt();
      		
			
      		}while(ch!=0);
      	}catch(Exception e) {
      		System.out.println(e);
      	}
}
	
	void getConnect() {
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/data";
		String name="root";
		String password="pranav1910";
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,name,password);
			System.out.println("Database connected");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void createtable() {
		try {
			String query="create table Student(rollno int primary key ,name varchar(10),sub varchar(30),mark int)";
			PreparedStatement ps=con.prepareStatement(query);
			int i=ps.executeUpdate();
			System.out.println("table created sucessfully"+i);
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("select next operation");
		}
}
	
	void insertdata()throws Exception {
		Data.get_data();
		String query="insert into Student values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, Data.getrollno());
		ps.setString(2, Data.getname());
		ps.setString(3, Data.getsub());
		ps.setInt(4, Data.getmarks());
		
		int i=ps.executeUpdate();
		System.out.println("no.of rows affected"+i);
		
	}
	
	void fetchdata()throws Exception {
		String query="select * from Student";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		System.out.println("Rollno" +"\t"+"Std_name"+"\t"+"Sub_name"+"\t"+"Marks");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
		}
		
	}
	
	void updatedata()throws Exception {
		int rollno,marks;
		Scanner sc=new Scanner(System.in);
		System.out.println("Entre roll updated roll no");
		rollno=sc.nextInt();
		System.out.println("Entre the updated mark");
		marks=sc.nextInt();
		String query="update Student set mark=? where rollno=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,marks);
		ps.setInt(2, rollno);
		
		int i=ps.executeUpdate();
		System.out.println("no of rows update="+i);
	}
	
	void searchdata()throws Exception{
		int rollno;
		Scanner sc=new Scanner(System.in);
		System.out.println("Entre the roll no for search=");
		rollno=sc.nextInt();
		String query="select * from Student where rollno=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, rollno);
		ResultSet rs=ps.executeQuery();
    	System.out.println("Rollno" +"\t"+ "Student_name"+"\t"+"Subject_name"+"\t"+"Marks");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t        "+rs.getString(3)+"\t         "+rs.getInt(4));
		}
	
	}
	
	void deletedata()throws Exception{
		int rollno;
		System.out.println("Entre the roll no for delete=");
		Scanner sc=new Scanner(System.in);
		rollno=sc.nextInt();
		String query="delete from Student where rollno=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, rollno);
		int i=ps.executeUpdate();
		System.out.println("no of rows delete "+i);
		}
	
    void closeconnection()throws SQLException
    {
    	con.close();
    	System.out.println("Closed database connection");
    }
}

class Base{
	int rollno;
	String name;
	public void get_data() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Entre the roll no");
		rollno=sc.nextInt();
		sc.nextLine();
		System.out.println("Entre the name");
		name=sc.nextLine();

	}
	public int getrollno()
	{
		return rollno;
	}
	public String getname()
	{
		return name;
	}
}

class Derived extends Base 
{
	int marks;
	String sub;
	
	public void get_data()
	{
		Scanner in=new Scanner(System.in);
		super.get_data();
		System.out.println("Enter the sub name");
		sub=in.next();
		System.out.println("Entre mark");
		marks=in.nextInt();
	}
	public String getsub()
	{
		return sub;
	}
	public int getmarks()
	{
		return marks;
	}
}