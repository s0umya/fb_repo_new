package com.fetch.fbapp3.model;

import java.io.Serializable;
import java.util.*;
public class User implements Serializable{
	

	//@Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)	
	//@Column
	    private int userID;
		public int getUserID() {
			return userID;
		}

		public void setUserID(int userID) {
			this.userID = userID;
		}

		private String emailID;
		
		//@Column
		private String password;
		
		//@Column
		private String name;
		
		//@Column
		private Date dob;
		private String date;
		
		//@Column
		private String pic;
		
		//@Column
		private String town;
		
		public User(String emailID, String password, String name, Date dob, String pic, String town,String date) {
			super();
			this.emailID = emailID;
			this.password = password;
			this.name = name;
			this.dob = dob;
			this.pic = pic;
			this.date=date;
			this.town = town;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public User()
		{
			
		}
		

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

		
	
	
}//user class ends here

