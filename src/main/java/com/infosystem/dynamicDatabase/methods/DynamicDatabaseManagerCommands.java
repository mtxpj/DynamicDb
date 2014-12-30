package com.infosystem.dynamicDatabase.methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infosystem.dynamicDatabase.DynamicDatabaseManager;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class DynamicDatabaseManagerCommands implements DynamicDatabaseManager {

	public String createOrUpdate(TableDefinition tableDefinition) {
		MaintainConnection.connect(tableDefinition.getId());
		String sql = SqlBuilder.create(tableDefinition);
		try {
			ResultSet rs = ConnectionStatus.statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteTable(String tableId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existsTable(String tableId) {
		// TODO Auto-generated method stub
		return false;
	}

	public Long insertDataRow(DataRow row) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DataRow> getDataRows(QueryParams queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteDataRow(String tableId, Long rowId) {
		// TODO Auto-generated method stub
		return false;
	}

	public void updateDataRow(DataRow row) {
		// TODO Auto-generated method stub

	}

}