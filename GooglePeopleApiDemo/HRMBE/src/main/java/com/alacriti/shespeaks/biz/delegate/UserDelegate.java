package com.alacriti.shespeaks.biz.delegate;

import java.sql.Connection;

import com.alacriti.shespeaks.bo.ISampleBO;
import com.alacriti.shespeaks.bo.impl.SampleBO;
import com.alacriti.shespeaks.bo.impl.UserRoleBO;
import com.alacriti.shespeaks.log.impl.AppLogger;
import com.alacriti.shespeaks.model.vo.UserRoleVO;
import com.alacriti.shespeaks.util.LogUtil;

public class UserDelegate extends BaseDelegate {

	private static final AppLogger log = LogUtil.getLogger(UserDelegate.class);


	public void getUserRole(UserRoleVO userVO) {
		log.debugPrintCurrentMethodName();
		log.logInfo("In User delegate*******getUserRole");
		log.logInfo("In User delegate***userVO.getRoleTypeId****"+userVO.getRoleTypeId());
		
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRoleBO userRoleBO= new UserRoleBO(getConnection());
			userRoleBO.getUserRole(userVO);
		} catch (Exception e) {
			log.logError("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
	
	public void createUserRole(UserRoleVO userRoleVO){
		log.logInfo("In User delegate*********createUserRole");
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserRoleBO userRoleBO= new UserRoleBO(getConnection());
			userRoleBO.createUserRole(userRoleVO);
		} catch (Exception e) {
			log.logError("Exception in getMessage " + e.getMessage(), e);
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
	}
}
