package com.cs361.luan.sample;

/**
 * Created by luan on 8/6/15.
 */
public class UserData{

    private int deviceID;
    private int quantity;   // multiplier for shower time, etc.
    private int gallons;		// these are what you need to worry about
    private String name;
    private String date;

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getGallons() {
        return gallons;
    }

    public void setGallons(int gallons) {
        this.gallons = gallons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}



