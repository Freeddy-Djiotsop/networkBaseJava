import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	
	private ServerSocket serverSocket;
	private Socket client;
	private InputStream fromClient;
	private OutputStream toClient;

	public Server()
	{
		try 
		{
			System.out.println("Waiting...");
			serverSocket = new ServerSocket(1234);
			client = serverSocket.accept();
			System.out.println("Connexion done");
			
			/*For the communication*/
			fromClient = client.getInputStream();
			toClient = client.getOutputStream();
			
			/*Receving data*/
			int a = fromClient.read();
			System.out.println(a+" Recieved From client");
			int b = fromClient.read();
			System.out.println(b+" Recieved from Client");
			
			/*sending the result*/
			int c = a + b;
			toClient.write(c);
			System.out.println(c+" Sent to client");
		} 
		catch (IOException e) {System.out.println("Connexion failled!!!");}
		
	}

	public static void main(String[] args)
	{
		new Server();
	}

}
