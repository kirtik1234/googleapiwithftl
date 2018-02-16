package com.alacriti.shespeaks.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.shespeaks.dao.ISampleDAO;
import com.alacriti.shespeaks.log.impl.AppLogger;
import com.alacriti.shespeaks.util.LogUtil;

public class SampleDAO extends BaseDAO implements ISampleDAO {
	private static final AppLogger log = LogUtil.getLogger(SampleDAO.class);

	public SampleDAO() {

	}

	public SampleDAO(Connection conn) {
		super(conn);
	}

	public String selectMessage() throws DAOException {
		log.debugPrintCurrentMethodName();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Connection connection = null;
		try {
			connection = getConnection();
			String sqlCmd = "sql command";
			stmt = super.getPreparedStatementReturnPK(connection, sqlCmd);
			rs = stmt.getGeneratedKeys();
		} catch (SQLException e) {
			log.logError(
					"SQLException in selectMessage " + e.getMessage(), e);
			throw new DAOException("SQLException in selectMessage():", e);
		} finally {
			close(stmt, rs);
		}
		return "Heelloo World titlke";
	}

}
