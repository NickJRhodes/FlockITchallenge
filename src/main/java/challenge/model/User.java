package challenge.model;

import java.util.Date;

/**
 * 
 * @author Nicolas Rodriguez
 * @since 1.0.0
 *
 */
public class User {
	
	private String username;
	private Date loginDate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
			.append("\n====USER====")
			.append("\nusername: " + this.username)
			.append("\nloginDate: " + this.loginDate.toString())
			.append("\n");
		
		return stringBuilder.toString();
	}

}
