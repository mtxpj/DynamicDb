package com.infosystem.dynamicDatabase.methods;

import java.sql.SQLException;
import java.util.List;

import com.infosystem.dynamicDatabase.App;
import com.infosystem.dynamicDatabase.DynamicDatabaseManager;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class Methods implements DynamicDatabaseManager {

	
	public String createOrUpdate(TableDefinition tableDefinition) {
		
		// zapewnienie po³¹czenia
		MaintainConnection.connect(App.DB_NAME);
		
		// przygotowanie komendy
		String command = SqlBuilder.createOrUpdate(tableDefinition);
		
		// obs³uga komendy
		try {
			ConnectionStatus.statement.executeUpdate(command);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("b³¹d polecenia SQL w metodzie createOrUpdate");
			return "b³¹d polecenia SQL w metodzie createOrUpdate";
		}
		
		return null;
	}

	
	public boolean deleteTable(String tableId) {
		
		// zapewnienie po³¹czenia
		MaintainConnection.connect(App.DB_NAME);
		
		// przygotowanie komendy
		String command = SqlBuilder.deleteTable(tableId);
		
		// obs³uga komendy
		try {
			ConnectionStatus.statement.executeUpdate(command);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("b³¹d polecenia SQL w metodzie deleteTable");
			return false;
		}
		
		return true;
	}

	
	public boolean existsTable(String tableId) {
		
		// zapewnienie po³¹czenia
		MaintainConnection.connect(App.DB_NAME);
		
		// obs³uga komendy
		try {
			return TableExist.ifExist(tableId);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("b³¹d polecenia SQL w metodzie existsTable");
		}
		
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