package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class ReimbDAO implements ReimbDAOInterface {

	@Override
	public boolean submitReimbursement(Reimbursement reimbursement) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
		String sql = "insert into reimbursements (reimb_amount, reimb_status, reimb_author) values (?, ?, ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setFloat(1, reimbursement.getReimb_amount());
		ps.setString(2, "PENDING");
		ps.setInt(3, reimbursement.getReimb_author());
		
		System.out.println(ps);
		
		ps.executeUpdate();
		
		System.out.println("Your reimbursement request was successfully submitted.");
		
		return true;
			
		} catch (SQLException e) {
			System.out.println("Reimbursement submission failed.");
			e.printStackTrace();
		}
		
		return false;
	} //END OF submitReimbursement()
	

	@Override
	public ArrayList<Reimbursement> viewReimbursements(String reimb_status) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from reimbursements where reimb_status = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, reimb_status);
			ResultSet rs = ps.executeQuery();
			ArrayList<Reimbursement> reimbList = new ArrayList<>();
			while (rs.next()) {
				Reimbursement r = new Reimbursement (
						rs.getInt("reimb_id"),
						rs.getFloat("reimb_amount"),
						rs.getString("reimb_status"),
						null
						);
				int UserFK = rs.getInt("reimb_author");
				UserDAO uDAO = new UserDAO();
				User u = uDAO.getUserByID(UserFK);
				r.setUser(u);
				reimbList.add(r);
			} //end of while loop
			
			return reimbList;
			
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG GETTING REIMBURSEMENTS");
			e.printStackTrace();
		}
		
		return null;
	} //END OF viewReimbursements()

	@Override
	public ArrayList<Reimbursement> viewAllReimbursements() {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from reimbursements;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<Reimbursement> reimbList = new ArrayList<>();
			while (rs.next()) {
				Reimbursement r = new Reimbursement (
						rs.getInt("reimb_id"),
						rs.getFloat("reimb_amount"),
						rs.getString("reimb_status"),
						null
						);
				int UserFK = rs.getInt("reimb_author");
				UserDAO uDAO = new UserDAO();
				User u = uDAO.getUserByID(UserFK);
				r.setUser(u);
				reimbList.add(r);
			} //end of while loop
			
			return reimbList;
			
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG GETTING REIMBURSEMENTS");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	@Override
	public ArrayList<Reimbursement> viewEmployeeReimbs(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from reimbursements where reimb_author = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ArrayList<Reimbursement> reimbList = new ArrayList<>();
			while (rs.next()) {
				Reimbursement r = new Reimbursement (
						rs.getInt("reimb_id"),
						rs.getFloat("reimb_amount"),
						rs.getString("reimb_status"),
						null
						);
				int UserFK = rs.getInt("reimb_author");
				UserDAO uDAO = new UserDAO();
				User u = uDAO.getUserByID(UserFK);
				r.setUser(u);
				reimbList.add(r);
		}
			
			return reimbList;
			
		}   catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG GETTING REIMBURSEMENTS");
			e.printStackTrace();
	}
		return null;
	
	}
	
	@Override
	public boolean updateReimbStatus(int reimb_id, String reimb_status) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "update reimbursements set reimb_status = ? where reimb_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, reimb_status);
			ps.setInt(2, reimb_id);
			ps.executeUpdate();
			System.out.println("Reimbursement ID#" + reimb_id + " has been updated to " + reimb_status);
			return true;
			
		} catch (SQLException e) {
			System.out.println("FAILED TO UPDATE");
			e.printStackTrace();
		}
		
		return false;
	}
	
}

