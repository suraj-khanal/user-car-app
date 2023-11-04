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

	@Override
	public String toString() {
		return "LoginHistory [lhid=" + lhid + ", login_time=" + login_time + ", logout_time=" + logout_time
				+ ", userSignup=" + userSignup + "]";
	}
	
	
	
}
