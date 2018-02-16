package com.alacriti.shespeaks.bo.impl;

import java.sql.Connection;

import com.alacriti.shespeaks.log.impl.AppLogger;
import com.alacriti.shespeaks.util.LogUtil;


public class BaseBO {
	private static final AppLogger log = LogUtil.getLogger(BaseBO.class);
	private Connection connection = null;

	public BaseBO() {
	}

	public BaseBO(Connection connection) {
		log.debugPrintCurrentMethodName();
		this.connection = connection;
	}

	public Connection getConnection() {
		log.debugPrintCurrentMethodName();
		return connection;
	}

	public void setConnection(Connection connection) {
		log.debugPrintCurrentMethodName();
		this.connection = connection;
	}
}
