package com.emk.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import org.json.simple.JSONObject;

public class MainDAO {
	
	public JSONObject getData(int temp) throws SQLException, NamingException {
		DBUtil db = new DBUtil();
		String query = "select clothes from clothes where celsius = ?";
		int temp_db = 0;
		if (temp >= 28) {
			temp_db = 28;
			
		}
		else if (temp <= 27 && temp > 22 ) {
			temp_db = 27;
		}
		else if (temp <= 22 && temp > 19 ) {
			temp_db = 22; 
		}
		else if (temp <= 19 && temp > 16 ) {
			temp_db = 19;
		}
		else if (temp <= 16 && temp > 11 ) {
			temp_db = 16;
		}
		else if (temp <= 11 && temp > 8 ) {
			temp_db = 11; 
		}
		else if (temp <= 8 && temp > 4 ) {
			temp_db = 8;
		}
		else if (temp <= 4 ) {
			temp_db = 4; 
		}
		
		PreparedStatement pstmt = db.createPstmt(query);
		pstmt.setInt(1, temp_db);
		
		ResultSet rs = pstmt.executeQuery();
		JSONObject json = new JSONObject();
		ArrayList list = new ArrayList();
		
		while(rs.next()) {
			list.add(rs.getString("clothes"));
		
		}
		
		json.put("clothes", list);
		return json;
	}

}
