package com.alacriti.shespeaks.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.shespeaks.log.impl.AppLogger;
import com.alacriti.shespeaks.model.vo.UserRoleVO;
import com.alacriti.shespeaks.util.LogUtil;

public class UserDAO extends BaseDAO{
	private static final AppLogger log = LogUtil.getLogger(UserDAO.class);
	public UserDAO(Connection conn) {
		super(conn);
	}
	public UserDAO(){
		
	}
	public void getUserRole(UserRoleVO userVO) throws DAOException {
		log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sqlCmd = "sql command";
			
			stmt =getPreparedStatementGetUserRole(getConnection(), sqlCmd);
			stmt.setInt(1,userVO.getRoleTypeId());
			log.logDebug("reached here********");
			rs= stmt.executeQuery();
			while(rs.next()){
				userVO.setRoleTypeId(rs.getInt(1));
				userVO.setRoleName(rs.getString(2));
			}
			log.logDebug("userVO.UserAcctId********"+userVO.getRoleTypeId());
			log.logDebug("userVO.RoleName********"+userVO.getRoleName());
		} catch (SQLException e) {
			log.logError(
					"SQLException in getUserRole " + e.getMessage(), e);
			throw new DAOException("SQLException in getUserRole():", e);
		} finally {
			close(stmt, rs);
		}
	}
	
	public PreparedStatement getPreparedStatementGetUserRole(Connection connection, String sqlCmd) throws SQLException{
		log.debugPrintCurrentMethodName();

		log.logInfo("getPreparedStatement: " + sqlCmd);
		try {

			return connection.prepareStatement("select role_type_id, role_type from role_type_tbl"
					+ "where role_type_id=?");
		} catch (SQLException e) {
			log.logError("Exception in getPreparedStatementGetUserRole " + e.getMessage(), e);
			throw e;
		}
	}
	
	
	public void createUserRole(UserRoleVO userRoleVO) throws DAOException{
		log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sqlCmd = "sql command";
			
			stmt =getPreparedStatementCreateUserRole(getConnection(), sqlCmd);
			stmt.setInt(1,userRoleVO.getRoleTypeId());
			stmt.setString(2, userRoleVO.getRoleName());
			stmt.setString(3, userRoleVO.getRoleDesc());
			log.logDebug("reached here********");
			int count= stmt.executeUpdate();
			if(count>0){
				userRoleVO.setRoleCreate(true);
			}
		} catch (SQLException e) {
			log.logError(
					"SQLException in createUserRole " + e.getMessage(), e);
			throw new DAOException("SQLException in createUserRole():", e);
		} finally {
			close(stmt, rs);
		}
	}
	
	public PreparedStatement getPreparedStatementCreateUserRole(Connection connection, String sqlCmd) throws SQLException{
		try {
			return connection.prepareStatement("insert into role_type_tbl values(?,?,?)");
		} catch (SQLException e) {
			log.logError("Exception in getPreparedStatementCreateUser " + e.getMessage(), e);
			throw e;
		}
	}

}
