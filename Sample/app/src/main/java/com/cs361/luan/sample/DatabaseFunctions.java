package com.cs361.luan.sample;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFunctions{

	private int id;
	private static boolean isLogin = false, isRegister = false;

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
			isLogin = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isLogin;
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @param name
	 * @param email
	 * @return
	 */
	public static boolean create(String username, String password, String name, String email) {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost("http://web.engr.oregonstate.edu/~kitchenr/WaDa/newuser.php");
			List<NameValuePair> postdata = new ArrayList<NameValuePair>(2);
			postdata.add(new BasicNameValuePair("username", username));
			postdata.add(new BasicNameValuePair("password", password));
			postdata.add(new BasicNameValuePair("name", name));
			postdata.add(new BasicNameValuePair("email", email));
			post.setEntity(new UrlEncodedFormEntity(postdata));
			HttpResponse response = client.execute(post);
			isRegister = true;
		} catch(Exception e) {
			e.printStackTrace();
		}

		return isRegister;
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