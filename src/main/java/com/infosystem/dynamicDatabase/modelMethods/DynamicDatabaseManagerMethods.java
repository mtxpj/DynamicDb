package com.infosystem.dynamicDatabase.modelMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infosystem.dynamicDatabase.DynamicDatabaseManager;
import com.infosystem.dynamicDatabase.RsultsetManager.ResultsetManager;
import com.infosystem.dynamicDatabase.SqlBuilder.SqlBuilder;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.constant.ConnectorData;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.Sort;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.infosystem.dynamicDatabase.model.filter.Filter;

public class DynamicDatabaseManagerMethods implements DynamicDatabaseManager {

	private static final String DB_NAME = ConnectorData.DB;

	public String createOrUpdate(TableDefinition tableDefinition) {
		if (existsTable(tableDefinition.getId())) {
			// update:
			return "tabela o podanej nazwie już istnieje";
		}
		String command = SqlBuilder.createOrUpdate(tableDefinition);
		try {
			MaintainConnection.connectLocalhostWithUserAndPassword(DB_NAME);
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie createOrUpdate");
			return "błąd polecenia SQL w metodzie createOrUpdate";
		}
		return null;
	}

	public boolean deleteTable(String tableId) {
		MaintainConnection.connectLocalhostWithUserAndPassword(DB_NAME);
		String command = SqlBuilder.deleteTable(tableId);
		try {
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie deleteTable");
			return false;
		}
		return true;
	}

	public boolean existsTable(String tableId) {
		MaintainConnection.connectLocalhostWithUserAndPassword(DB_NAME);
		try {
			return TableExist.ifExist(tableId);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie existsTable");
		}
		return false;
	}

	public Long insertDataRow(DataRow row) {
		MaintainConnection.connectLocalhostWithUserAndPassword(DB_NAME);
		String command = SqlBuilder.insertDataRow(row);
		try {
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
			return (long) -1;
		}
		return (long) row.getRowId();
	}

	public List<DataRow> getDataRows(QueryParams qp) {
		ResultSet rs = null;
		String tableId = qp.getTableId();
		int firstResult = qp.getFirstResult();
		int resultCount = qp.getResultCount();
		List<String> columnList = qp.getColumnList();
		List<Sort> sortColumns = qp.getSortColumns();
		Filter filter = qp.getFilter();

		String command = SqlBuilder.getDataRows(qp);
		try {
			MaintainConnection.connectLocalhostWithUserAndPassword(DB_NAME);
			rs = ConnectionStatus.getInstance().getStatement()
					.executeQuery(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (qp.getColumnList() == null) {
			try {
				for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					columnList.add(rs.getMetaData().getColumnName(i));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		List<DataRow> list = ResultsetManager.getRowsFromResultSet(rs,
				columnList);
		for (int i = 0; i < resultCount; i++) {
			DataRow dr = list.get(i);
			dr.setRowId((long) (firstResult + i));
			dr.setTableId(tableId);
		}
		return list;
	}

	public boolean deleteDataRow(String tableId, Long rowId) {
		MaintainConnection.connectLocalhostWithUserAndPassword(DB_NAME);
		String command = SqlBuilder.deleteDataRow(tableId, rowId);
		try {
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(command);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie deleteDataRow");
			return false;
		}
	}

	public void updateDataRow(DataRow row) {
		// TODO Auto-generated method stub

	}

}