package rmi;
import java.rmi.*;
import java.util.*;


public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PrintI obj=(PrintI)Naming.lookup("rmi://localhost:5000/Check");
		String s;
		System.out.println("Enterr the String:");
		s=sc.nextLine();
		boolean ans=obj.Check(s);
		if(ans) {
			System.out.println("It is palindrome");
		}
		else {
			System.out.println("It is not palindrome");
		}

	}

}
