package rmi_app;
import java.rmi.*;

public interface PrintI extends Remote {
	public boolean Check(String str)throws RemoteException;

}
