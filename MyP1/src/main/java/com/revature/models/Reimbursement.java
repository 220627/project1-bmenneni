package com.revature.models;

//Class to model Reimbursements table
public class Reimbursement {
	
	private int reimb_id;
	private float reimb_amount;
	private String reimb_status;
	private User user;
	private int reimb_author;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimb_id, float reimb_amount, String reimb_status, User user) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_status = reimb_status;
		this.user = user;
	}
	
	//all-args constructor minus reimbursement ID
	public Reimbursement(float reimb_amount, String reimb_status, User user) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_status = reimb_status;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reimbursements [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_status="
				+ reimb_status + ", user=" + user + ", reimb_author=" + reimb_author + "]";
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public float getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(float reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public String getReimb_status() {
		return reimb_status;
	}

	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	
}


