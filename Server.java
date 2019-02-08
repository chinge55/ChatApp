import java.io.*;
import java.net.*;

public class Server
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(4000);
		System.out.println("Server Ready");
		Socket client = server.accept();
		System.out.println("Client Connected");

		BufferedReader reads = new BufferedReader(new InputStreamReader(System.in));

		OutputStream ostream = client.getOutputStream();
		PrintWriter writer = new PrintWriter(ostream, true);
	
		// read from the client
		InputStream istream = client.getInputStream();
		BufferedReader read_received = new BufferedReader(new InputStreamReader(istream));

		String str_recievemessage, str_sendmessage;
		
		while(true)
		{
			if((str_recievemessage = read_received.readLine())!=null)
				System.out.println(str_recievemessage);
			str_sendmessage = reads.readLine();
			writer.println(str_sendmessage);
			writer.flush();
		}

	}
}
