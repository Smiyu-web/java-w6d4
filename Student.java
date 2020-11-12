package ca.java.collection.practice;

import java.util.regex.Pattern;

public class Student {

	private int id;
	private String email;
	private String fullName;
	
	private final String UNKNOWN = "Unknown";
	
	public Student(int id, String email, String fullName) {
		setId(id);
		setEmail(email);
		setFullName(fullName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String pattern = "^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$";
		Pattern p = Pattern.compile(pattern);
		if (!email.isEmpty() && !email.equalsIgnoreCase(null)) {
			if (p.matcher(email).find()) {
			this.email = email;
		    } else {
		    	this.email = "Invalid email";
		    }
		} else {
			this.email = UNKNOWN;
		}
	}
	

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		if (!fullName.isEmpty() && !fullName.equalsIgnoreCase(null)) {
			this.fullName = fullName;
		} else {
			this.fullName = UNKNOWN;
		}	}

	@Override
	public String toString() {
		return "\nid : " + id + 
				", email : " + email + 
				", fullName : " + fullName;
	}

}
