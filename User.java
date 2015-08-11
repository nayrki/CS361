import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.params.HttpMethodParams;



public class User{
	private static int id;
	public static boolean logged_in;
	
	public static boolean login(String username, String password)
	{
		HttpClient client = new DefaultHttpClient();
		HttpPOST post = new HttpPost("http://web.engr.oregonstate.edu/~kitchenr/WaDa/login.php");
		List<NameValuePair> postdata = new ArrayList<NameValuePair>(2);
		postdata.add(new BasicNameValuePair("username",username));
		postdata.add(new BasicNameValuePair("password",password));
		post.setEntity(new UrlENcodedFormEntity(postdata));
		
		HttpResponse response = client.execute(post);
		
		return true;
	}
	
	public static boolean create(String username, String password, String name, String email){
		HttpClient client = new DefaultHttpClient();
		HttpPOST post = new HttpPost("http://web.engr.oregonstate.edu/~kitchenr/WaDa/newuser.php");
		List<NameValuePair> postdata = new ArrayList<NameValuePair>(2);
		postdata.add(new BasicNameValuePair("username",username));
		postdata.add(new BasicNameValuePair("password",password));
		postdata.add(new BasicNameValuePair("name",name));
		postdata.add(new BasicNameValuePair("email",email));
		post.setEntity(new UrlENcodedFormEntity(postdata));
		
		HttpResponse response = client.execute(post);
		
		
		return true;
	}
	
	/*
		deviceID
		toilet = 1
		shower = 2

		usage:
			User.addEvent(deviceID,1);
	*/
	public static boolean addEvent(int deviceID, int quantity){
		return true;
	};
	
	public class UserData{ 
		public int deviceID;
		public int quantity;   // multiplier for shower time, etc.
		public int gallons;		// these are what you need to worry about
		public String name;
		public String date;	
	};
	
	// usage: UserData[] (var name) = User.getUserData();
	
	public static UserData[] getUserData(){   // Returns array of UserData entries;
		return new UserData[1];
	};
};