




public class User{
	static private int id;
	static public boolean logged_in;
	
	static public boolean login(String username, String password)
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
	
	/*
		deviceID
		toilet = 1
		shower = 2

		usage:
			User.addEvent(deviceID,1);
	*/
	static public boolean addEvent(int deviceID, int quantity){
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
	
	static public UserData[] getUserData(){   // Returns array of UserData entries;
		return new UserData[];
	};
};