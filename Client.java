import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client 
{
	private Socket server;
	private InputStream fromServer;
	private OutputStream toServer;

	public Client() 
	{
		try
		{
			server = new Socket("localhost", 1234);/*connect to server*/
			
			/*Preparing communication with Server*/
			fromServer = server.getInputStream();
			toServer = server.getOutputStream();
			
			/*Sending data*/
			toServer.write(10);
			System.out.println("10 Sent to Server");
			toServer.write(-5);
			System.out.println("-5 Sent to Server");
			int c = fromServer.read();
			System.out.println(c+" Recieved From Server");
		} 
		catch (UnknownHostException e) { System.out.println("Unknow host");}
		catch (IOException e) { System.out.println("Connection failled");}
	}

	public static void main(String[] args) 
	{
		new Client();
	}
}
