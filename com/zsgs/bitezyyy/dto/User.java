package com.zsgs.bitezyyy.dto;

import java.util.List;

public class User {
    private String name;
	private String emailId;
	private String userId;
	private String dob;
	private long phoneNo;
	private Order currOrder;
	private List<Order> userOrderLog;

	public User(String name, String emailId, String userId, long phoneNo){
		this.name = name;
		this.emailId = emailId;
		this.userId = userId;
		this.phoneNo = phoneNo;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

    public void setCurrOrder(Order userOrder) {
        this.currOrder = userOrder;
    }

	public List<Order> getUserOrderLog(){
		return userOrderLog;
	}
}


