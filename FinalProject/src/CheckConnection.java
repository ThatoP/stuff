import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JFrame;

public class CheckConnection {
	public static void main(String[] args) {
		CheckConnection c = new CheckConnection();
		String url = "http://iceworld.sls-atl.com/api/&cmd=time";
		System.out.println("Check Connection....");

		// this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
		// java.awt.Event.CTRL_MASK));

		if (checkConnection(url)) {
			System.out.println("Connection OK.");
			System.out.println(url);
			
			Menubar newFrame = new Menubar();
			newFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			newFrame.pack();
			newFrame.setVisible(true);
			c.getRequest();
		} else {
			System.out.println("Cannot connect to Server");
		}
	}

	private static boolean checkConnection(String request) {
		try {
			String urlParameters = "param1=a&param2=b&param3=c";
			URL url = new URL(request);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("Content-Length",
					"" + Integer.toString(urlParameters.getBytes().length));
			connection.setUseCaches(false);

			DataOutputStream wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			connection.disconnect();
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	public void getRequest(){
		
		try{
			
			Scanner kb = new Scanner (System.in);
			System.out.print("Enter: ");
			
			String requestName = kb.next();
			
			URL request;
			
			if(requestName.equals("time")){
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=time");
			}else if(requestName.equals("state")){
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=states");
			}else if (requestName.equals("actions")){
				System.out.print("from: ");
				String from = kb.next();
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=actions&from="+from);
			}else if (requestName.equals("gresources")){
				System.out.print("uid: ");
				String uid = kb.next();
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=gresources&uid="+uid);
			}else if( requestName.equals("gurl")){
				System.out.print("gid: ");
				String gid = kb.next();
				request = new URL("http://iceworld.sls-atl.com/api/&cmd=gurl&gid="+gid);
			}else{
				System.out.println("Invalid request");
				request = null;
			}
			if(request!=null){
				BufferedReader in = new BufferedReader(
						new InputStreamReader(request.openStream()));

				String inputLine;
				while ((inputLine = in.readLine()) != null)
					System.out.println(inputLine);
				in.close();
			}
			System.out.println("--------------------------");
			getRequest();
			
		} catch (MalformedURLException e) {
			System.out.println("Cannot get request");
			System.out.println("--------------------------");
			getRequest();
			// new URL() failed
			// ...
		} catch (IOException e) {
			System.out.println("Cannot get request");
			System.out.println("--------------------------");
			getRequest();
			// openConnection() failed
			// ...
		}
		/*
		URL oracle = new URL("http://www.oracle.com/");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
*/
	}

}
