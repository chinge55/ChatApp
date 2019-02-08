import java.io.*;
import java.net.*;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		Socket client = new Socket("127.0.0.1", 4000);
		BufferedReader readdata = new BufferedReader(new InputStreamReader(System.in));
		

		OutputStream ostream = client.getOutputStream();
		PrintWriter writer = new PrintWriter(ostream, true);

		// receiving data from the server
		InputStream istream = client.getInputStream();
		BufferedReader read_received = new BufferedReader(new InputStreamReader(istream));

		System.out.println("Type message and press enter");

		String str_receivedmessage, str_sentmessage;

		while(true)
		{
			// send message 
			str_sentmessage = readdata.readLine();
			writer.println(str_sentmessage);// sending message to the server
			writer.flush();
			str_receivedmessage = read_received.readLine();// receiving from the server
			if(str_receivedmessage!=null)
			{
				System.out.println(str_receivedmessage);// display
			}
		}
	
	}

}
