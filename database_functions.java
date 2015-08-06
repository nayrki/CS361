




static public class User{
	private int id;
	static public boolean logged_in;
	
	static public boolean login(String username, String Password)
	{
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