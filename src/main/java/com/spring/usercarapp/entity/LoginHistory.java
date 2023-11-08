package com.spring.usercarapp.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="login_history_tbl")
public class LoginHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="lhid")
	private int lhid;
	
	private Timestamp login_time;
	private Timestamp logout_time;
	
	private String duration;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="username", unique = false, nullable =false)
	private UserSignup userSignup;

	public int getLhid() {
		return lhid;
	}

	public void setLhid(int lhid) {
		this.lhid = lhid;
	}

	public Timestamp getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Timestamp login_time) {
		this.login_time = login_time;
	}

	public Timestamp getLogout_time() {
		return logout_time;
	}

	public void setLogout_time(Timestamp logout_time) {
		this.logout_time = logout_time;
	}

	public UserSignup getUserSignup() {
		return userSignup;
	}

	public void setUserSignup(UserSignup userSignup) {
		this.userSignup = userSignup;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "LoginHistory [lhid=" + lhid + ", login_time=" + login_time + ", logout_time=" + logout_time
				+ ", duration=" + duration + ", userSignup=" + userSignup + "]";
	}
	
	public String formatDuration(long durationInMillis) {
		
	    long milliseconds = durationInMillis % 1000;
	    long seconds = (durationInMillis / 1000) % 60;
	    long minutes = (durationInMillis / (1000 * 60)) % 60;
	    long hours = (durationInMillis / (1000 * 60 * 60)) % 24;
	    long days = durationInMillis / (1000 * 60 * 60 * 24);

	    
	    StringBuilder formattedDuration = new StringBuilder();

	    if (days > 0) {
	        formattedDuration.append(days).append("d:");
	    }
	    if (hours > 0) {
	        formattedDuration.append(hours).append("h:");
	    }
	    if (minutes > 0) {
	        formattedDuration.append(minutes).append("m:");
	    }
	    if (seconds > 0) {
	        formattedDuration.append(seconds).append("s:");
	    }
	    formattedDuration.append(milliseconds).append("ms");

	    return formattedDuration.toString();
	}

	

}
