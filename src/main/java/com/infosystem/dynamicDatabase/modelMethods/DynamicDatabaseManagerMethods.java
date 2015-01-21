package com.infosystem.dynamicDatabase.modelMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.infosystem.dynamicDatabase.DynamicDatabaseManager;
import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.SqlBuilder.SqlBuilder;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.Sort;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.infosystem.dynamicDatabase.model.filter.Filter;

public class DynamicDatabaseManagerMethods implements DynamicDatabaseManager {

	private static final String DB_NAME = DataForTests.getTestDb();

	public String createOrUpdate(TableDefinition tableDefinition) {
		// zapewnienie połączenia
		MaintainConnection.connect(DB_NAME);
		// sprawdzenie czy table o podanej nazwie istnieje
		if (existsTable(tableDefinition.getId())) {
			return "tabela o podanej nazwie już istnieje";
		}
		// przygotowanie komendy
		String command = SqlBuilder.createOrUpdate(tableDefinition);
		// obsługa komendy
		try {
			ConnectionStatus.statement.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie createOrUpdate");
			return "błąd polecenia SQL w metodzie createOrUpdate";
		}
		return null;
	}

	public boolean deleteTable(String tableId) {
		// zapewnienie połączenia
		MaintainConnection.connect(DB_NAME);
		// przygotowanie komendy
		String command = SqlBuilder.deleteTable(tableId);
		// obsługa komendy
		try {
			ConnectionStatus.statement.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie deleteTable");
			return false;
		}
		return true;
	}

	public boolean existsTable(String tableId) {
		// zapewnienie połączenia
		MaintainConnection.connect(DB_NAME);
		// obsługa komendy
		try {
			return TableExist.ifExist(tableId);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie existsTable");
		}
		return false;
	}

	public Long insertDataRow(DataRow row) {
		try {
			MaintainConnection.connectLocalhostWithUserAndPassword(DB_NAME);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String command = SqlBuilder.insertDataRow(row);
		try {
			ConnectionStatus.statement.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
			return (long) -1;
		}
		return (long) row.getRowId();
	}

	@SuppressWarnings("null")
	public List<DataRow> getDataRows(QueryParams qp) {
		List<DataRow> list = null;
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
			rs = ConnectionStatus.statement.executeQuery(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < resultCount; i++) {
			Map<String, DataHolder> data = null;
			for (int j = 0; j < columnList.size(); j++) {
				DataHolder dh = null;
				dh.setDataType(GetCorrectDataType.getDataTypeFromResultSet(rs));
				dh.
				data.put(columnList.get(j), dh);
				
			}
			DataRow dataRow = new DataRow();
			dataRow.setRowId((long) (firstResult+i));
			dataRow.setTableId(tableId);
			dataRow.setData(data);
			list.add(dataRow);
		}
		return list;
	}

	public boolean deleteDataRow(String tableId, Long rowId) {
		// zapewnienie połączenia
		try {
			MaintainConnection.connectLocalhostWithUserAndPassword(DB_NAME);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// przygotowanie komendy
		String command = SqlBuilder.deleteDataRow(tableId, rowId);
		// obsługa komendy
		try {
			ConnectionStatus.statement.executeUpdate(command);
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