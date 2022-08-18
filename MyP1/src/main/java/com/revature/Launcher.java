package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {

		System.out.println("========Welcome to the Employee Reimbursement System========");
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL");
		} catch (SQLException e) {
			System.out.println("CONNECTION FAILED");
			e.printStackTrace();
		}
		
		Javalin app = Javalin.create(
				
				config -> {
					config.enableCorsForAllOrigins();
				}
				
				).start(3000);
		
		ReimbController rc = new ReimbController();
		
		AuthController ac = new AuthController();
		
		app.post("/login", ac.loginHandler);
		
		app.post("/reimbursements", rc.submitReimbHandler);
		
		app.get("/reimbursements/all", rc.viewAllReimbursementsHandler);
		
		app.get("/reimb_management", rc.viewReimbursementsHandler);
		
		app.get("/reimbursements", rc.viewEmployeeReimbsHandler);
		
		app.put("/reimb_management", rc.updateReimbStatusHandler);
		
	}

}
