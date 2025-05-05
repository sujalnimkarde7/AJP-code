package rmi;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Registry reg=LocateRegistry.createRegistry(5000);
		PrintC obj=new PrintC();
		reg.bind("Check", obj);
		System.out.println("Server connnected");

	}

}
