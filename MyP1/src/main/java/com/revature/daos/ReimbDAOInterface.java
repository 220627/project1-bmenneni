package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbDAOInterface {

	//A method to submit a new reimbursement request - only for Employees
	boolean submitReimbursement(Reimbursement reimbursement);
	
	//A method to view all reimbursements - should be available only for Finance Managers
	ArrayList<Reimbursement> viewAllReimbursements();
	
	//A method to view all reimbursements by status - should be available only for Finance Managers.
	ArrayList<Reimbursement> viewReimbursements(String reimb_status);
	
	//A method for an Employee to view his own reimbursements
	ArrayList<Reimbursement> viewEmployeeReimbs(int id);
	
	//A method for Finance Managers to update reimbursement status
	boolean updateReimbStatus(int reimb_id, String reimb_status);
	
}
