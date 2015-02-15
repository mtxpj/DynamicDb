package com.infosystem.dynamicDatabase.modelMethods;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infosystem.dynamicDatabase.DynamicDatabaseManager;
import com.infosystem.dynamicDatabase.RsultsetManager.ResultsetManager;
import com.infosystem.dynamicDatabase.SqlBuilder.SqlBuilder;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.metaTablesMethods.MetaTablesHandler;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.Sort;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.infosystem.dynamicDatabase.model.dto.TableMetaDto;
import com.infosystem.dynamicDatabase.model.filter.Filter;
import com.mysql.jdbc.Statement;

public class DynamicDatabaseManagerMethods implements DynamicDatabaseManager {

	public String createOrUpdate(TableDefinition tableDefinition) {
		if (existsTable(tableDefinition.getKey())) {
			return "tabela o podanej nazwie już istnieje";
		} else {
			int tableKey = MetaTablesHandler.createOrUpdate(tableDefinition);
			tableDefinition.setKey(tableKey);
			String command = SqlBuilder.createOrUpdate(tableDefinition);
			try {
				MaintainConnection.connectLocalhost(DB);
				ConnectionStatus
						.getInstance()
						.getStatement()
						.executeUpdate(command, Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = ConnectionStatus.getInstance().getStatement()
						.getGeneratedKeys();
				if (rs.next()) {
					tableDefinition.setKey(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("błąd SQL w metodzie createOrUpdate");
				return "błąd polecenia SQL w metodzie createOrUpdate";
			}
		}
		return null;
	}

	public boolean deleteTable(String tableId) {
		MaintainConnection.connectLocalhost(DB);
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

	public boolean existsTable(int tableKey) {
		MaintainConnection.connectLocalhost(DB);
		try {
			return TableExist.ifExist(tableKey);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie existsTable");
		}
		return false;
	}

	public Long insertDataRow(DataRow row) {
		MaintainConnection.connectLocalhost(DB);
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
		List<DataRow> list = ResultsetManager.getRowsFromResultSet(rs,
				columnList);
		try {
			MaintainConnection.connectLocalhost(DB);
			rs = ConnectionStatus.getInstance().getStatement()
					.executeQuery(command);
			if (qp.getColumnList() == null) {
				for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
					columnList.add(rs.getMetaData().getColumnName(i));
				}
			}
			for (int i = 0; i < resultCount; i++) {
				DataRow dr = list.get(i);
				dr.setRowId((long) (firstResult + i));
				dr.setTableId(tableId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteDataRow(String tableId, Long rowId) {
		MaintainConnection.connectLocalhost(DB);
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

	public TableMetaDto getTableMetaData(String tableId) {
		// TODO Auto-generated method stub
		return null;
	}

}