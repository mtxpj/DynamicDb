package com.infosystem.dynamicDatabase.modelMethods;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.DB;

import java.sql.SQLException;
import java.util.List;

import com.infosystem.dynamicDatabase.DynamicDatabaseManager;
import com.infosystem.dynamicDatabase.SqlBuilder.SqlBuilder;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class MetaDatabaseManagerMethods implements DynamicDatabaseManager {

	public String createOrUpdate(TableDefinition tableDefinition) {
		if (existsTable(tableDefinition.getId())) {
			// update:
			return "tabela o podanej nazwie już istnieje";
		}
		String command = SqlBuilder.createOrUpdate(tableDefinition);
		try {
			MaintainConnection.connectLocalhostWithUserAndPassword(DB);
			ConnectionStatus.getInstance().getStatement()
					.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie createOrUpdate");
			return "błąd polecenia SQL w metodzie createOrUpdate";
		}
		return null;
	}

	public boolean existsTable(String tableId) {
		MaintainConnection.connectLocalhostWithUserAndPassword(DB);
		try {
			return TableExist.ifExist(tableId);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("błąd polecenia SQL w metodzie existsTable");
		}
		return false;
	}

	public boolean deleteTable(String tableId) {
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