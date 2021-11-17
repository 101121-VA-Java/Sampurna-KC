package com.revature.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class EmployeePostgres implements EmployeeDao {

	@Override
	public boolean submitReimbRequest(Reimbursement r) {
		String sql = "INSERT INTO ERS_REIMB (reimb_amount, reimb_author, "
				+ "reimb_status_id, reimb_type_id ) VALUES (?,?,?,?);";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1,r.getAmount());			
			ps.setInt(2, r.getAuthor().getUserId());
			ps.setInt(3, r.getStatus().getId());
			ps.setInt(4, r.getType().getId());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException | IOException e) {			
			e.printStackTrace();
			return false;
		}
				
		
	}

	@Override
	public ArrayList<Reimbursement> viewPendingReimb(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement viewResolvedReimb(User u) {
		// TODO Auto-generated method stub
		return null;
	}



}
