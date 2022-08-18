package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.ReimbDAO;
import com.revature.models.Reimbursement;

import io.javalin.http.Handler;

public class ReimbController {
	
	ReimbDAO rDAO = new ReimbDAO();
	
	public Handler submitReimbHandler = (ctx) -> {
		
		String body = ctx.body();
		Gson gson = new Gson();
		Reimbursement newReimb = gson.fromJson(body, Reimbursement.class);
		if(rDAO.submitReimbursement(newReimb)) {
			ctx.status(202);
		} else {
			ctx.status(406);
		}
	};
	
	public Handler viewAllReimbursementsHandler = (ctx) -> {
		
		if(AuthController.ses != null) {
			ArrayList<Reimbursement> reimbs = rDAO.viewAllReimbursements();
			Gson gson = new Gson();
			String reimbsJSON = gson.toJson(reimbs);
			ctx.result(reimbsJSON);
			ctx.status(200);
			
		} else {
			ctx.result("User is not logged in.");
			ctx.status(401);
		}
	};
	
	public Handler viewReimbursementsHandler = (ctx) -> {
		
		if(AuthController.ses != null) { //need to also restrict this functionality to only Financial Managers
			String reimb_status = ctx.pathParam("reimb_status");
			ArrayList<Reimbursement> reimbursements = rDAO.viewReimbursements(reimb_status);
			Gson gson = new Gson();
			String JSONreimbs = gson.toJson(reimbursements);
			ctx.result(JSONreimbs);
			ctx.status(200);
		
			
		} else {
			ctx.result("Insufficient permissions");
			ctx.status(401);
		}
		
	};
	
	
	public Handler viewEmployeeReimbsHandler = (ctx) -> {
		
		if(AuthController.ses != null) {
			int id = Integer.parseInt(ctx.pathParam("id"));
			ArrayList<Reimbursement> reimbursements = rDAO.viewEmployeeReimbs(id);
			Gson gson = new Gson();
			String JSONreimbs = gson.toJson(reimbursements);
			ctx.result(JSONreimbs);
			ctx.status(200);
		
		} else {
			ctx.result("Insufficient permissions");
			ctx.status(401);
		}
		
	};
	
	public Handler updateReimbStatusHandler = (ctx) -> { //should also be restricted to only Financial Managers
		int reimb_id = Integer.parseInt(ctx.pathParam("reimb_id")); 
		String reimb_status = ctx.body();
		
		if(rDAO.updateReimbStatus(reimb_id, reimb_status)) {
			ctx.status(202);
		} else {
			ctx.status(406);
		}
	};
	
}
