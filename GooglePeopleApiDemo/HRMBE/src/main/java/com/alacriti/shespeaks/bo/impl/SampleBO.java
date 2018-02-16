package com.alacriti.shespeaks.bo.impl;

import java.sql.Connection;

import com.alacriti.shespeaks.bo.ISampleBO;
import com.alacriti.shespeaks.dao.ISampleDAO;
import com.alacriti.shespeaks.dao.impl.DAOException;
import com.alacriti.shespeaks.dao.impl.SampleDAO;
import com.alacriti.shespeaks.log.impl.AppLogger;
import com.alacriti.shespeaks.util.LogUtil;


public class SampleBO extends BaseBO implements ISampleBO {
	private static final AppLogger log = LogUtil.getLogger(SampleBO.class);

	public SampleBO() {

	}

	public SampleBO(Connection conn) {
		super(conn);
	}
	public String retrieveMessage() throws BOException {
		log.debugPrintCurrentMethodName();
		ISampleDAO accountDAO = null;
		String msg = null;
		try {
			accountDAO = new SampleDAO(getConnection());
			msg = accountDAO.selectMessage();
		} catch (DAOException e) {
			log.logError("DAOException in retrieveMessage" + e.getMessage(), e);
			throw new BOException("DAOException Occured");
		} catch (Exception e) {
			log.logError("Exception in retrieveMessage " + e.getMessage(), e);
			throw new BOException();
		}
		return msg;
	}
}
