package rmi_app;
import java.rmi.*;
import java.util.*;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		PrintI obj=(PrintI)Naming.lookup("rmi://localhost:5000/Check");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the String");
		String strs=sc.nextLine();
		boolean ans=obj.Check(strs);
		if(ans)
		{
			System.out.println("Palindrome");
			
		}
		else {
			System.out.println("not palinndrome");
		}
		
		

	}

}
