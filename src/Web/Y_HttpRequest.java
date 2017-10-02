package Web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Y_HttpRequest {
	private String cookies = "";
	private String userAgent = "Mozilla/5.0"; // Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) 

	public String get(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		con.setRequestProperty("User-Agent", userAgent);
		con.setRequestProperty("Cookie", cookies);

		con.getResponseCode();

		BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {//read
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}

	public String post(String url, String post_parms) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", userAgent);
		con.setRequestProperty("Cookie", cookies); //Dang, this cant accept cookies....
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(post_parms);
		wr.flush();
		wr.close();

		con.getResponseCode();

		BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		return response.toString();
	}

	public void setCookies(String co) {
		cookies = co;
	}

	public String getUSerAgent() {
		return userAgent;
	}
	public void setUserAgent(String agent) {
		userAgent = agent;
	}
}
