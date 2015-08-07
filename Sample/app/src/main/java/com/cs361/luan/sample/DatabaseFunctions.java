package com.cs361.luan.sample;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class DatabaseFunctions{

	private int id;
	private boolean login;

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password) {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost("http://web.engr.oregonstate.edu/~kitchenr/WaDa/login.php");
			List<NameValuePair> postdata = new ArrayList<NameValuePair>(2);
			postdata.add(new BasicNameValuePair("username", username));
			postdata.add(new BasicNameValuePair("password", password));
			post.setEntity(new UrlEncodedFormEntity(postdata));
			HttpResponse response = client.execute(post);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	/**
	 * device ID toilet = 1
	 * device ID shower = 2
	 * usage: User.addEvent(deviceID,1);
	 */
	public static boolean addEvent(int deviceID, int quantity) {
		return true;
	};

};