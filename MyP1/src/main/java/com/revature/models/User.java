package com.revature.models;

public class User {

	private int user_id;
	private String username;
	private String user_password;
	private String user_first_name;
	private String user_last_name;
	private Role role;
	private int role_id_fk;
	
	public User() {
		super();
	}

	public User(int user_id, String username, String user_password, String user_first_name, String user_last_name,
			Role role, int role_id_fk) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.user_password = user_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.role = role;
		this.role_id_fk = role_id_fk;
	}
	
	public User(String username, String user_password, String user_first_name, String user_last_name,
			Role role, int role_id_fk) {
		super();
		this.username = username;
		this.user_password = user_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.role = role;
		this.role_id_fk = role_id_fk;
	}
	
	public User(int user_id, String user_first_name, String user_last_name) {
		super();
		this.user_id = user_id;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
	}
	
	public User(int user_id, String user_first_name, String user_last_name, int role_id_fk) {
		super();
		this.user_id = user_id;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.role_id_fk = role_id_fk;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", user_password=" + user_password
				+ ", user_first_name=" + user_first_name + ", user_last_name=" + user_last_name + ", role=" + role
				+ ", role_id_fk=" + role_id_fk + "]";
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getRole_id_fk() {
		return role_id_fk;
	}

	public void setRole_id_fk(int role_id_fk) {
		this.role_id_fk = role_id_fk;
	}
	
	
	
}

