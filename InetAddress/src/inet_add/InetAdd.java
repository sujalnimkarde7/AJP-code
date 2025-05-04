package inet_add;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdd {

	public static void main(String[] args) throws UnknownHostException {
		
		// TODO Auto-generated method stub
		InetAddress ip1=InetAddress.getLocalHost();
		System.out.println("1.address of local host"+ip1);
		
		InetAddress ip2=InetAddress.getByName("www.youtube.com");
		System.out.println("The add of youtube is: "+ip2);
		
		byte[] ipaddress= {10,10,13,38};
		InetAddress ip3=InetAddress.getByAddress(ipaddress);
		System.out.println("host name for ip is: "+ip3);
		
		InetAddress[] ip4=InetAddress.getAllByName("www.pict.edu");
		for(InetAddress add:ip4)
		{
			System.out.println("Address is: "+add);
			
		}
		InetAddress ip5=InetAddress.getByAddress("pict.edu", ipaddress);
		System.out.println("add of host with ip add: "+ip5);
		
		System.out.println("The host name of ip2 is: "+ip2.getHostName());
		
		System.out.println("host add is:"+ip2.getHostAddress());
		
		System.out.println("is ip2 is equal to ip1: "+ip2.equals(ip1));
		
		System.out.println("The string representation of ip2 is: "+ip2.toString());
		
	}

}
