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
		
		// zapewnienie połączenia
		MaintainConnection.connect(App.DB_NAME);
		
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
		MaintainConnection.connect(App.DB_NAME);
		
		// przygotowanie komendy
		String command = SqlBuilder.deleteTable(tableId);
		
		// obsługa komendy
		try {
			ConnectionStatus.statement.executeUpdate(command);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("b��d polecenia SQL w metodzie deleteTable");
			return false;
		}
		
		return true;
	}

	
	public boolean existsTable(String tableId) {
		
		// zapewnienie połączenia
		MaintainConnection.connect(App.DB_NAME);
		
		// obsługa komendy
		try {
			return TableExist.ifExist(tableId);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("b��d polecenia SQL w metodzie existsTable");
		}
		
		return false;
	}

	
	public Long insertDataRow(DataRow row) {
		
		// zapewnienie połączenia
		MaintainConnection.connect(App.DB_NAME);

		// przygotowanie komendy
		String command = SqlBuilder.insertDataRow(row);

		// obsługa komendy
		try {
			ConnectionStatus.statement.executeUpdate(command);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return (long)-1;
		}
		
		return (long) row.getRowId();
	}

	
	public List<DataRow> getDataRows(QueryParams queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public boolean deleteDataRow(String tableId, Long rowId) {
		
		// zapewnienie połączenia
		MaintainConnection.connect(App.DB_NAME);
				
		// przygotowanie komendy
		String command = SqlBuilder.deleteDataRow(tableId, rowId);
		
		// obsługa komendy
		try {
			ConnectionStatus.statement.executeUpdate(command);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("b��d polecenia SQL w metodzie deleteDataRow");
			return false;
		}
		
		return true;
	}
	
	

	public void updateDataRow(DataRow row) {
		// TODO Auto-generated method stub

	}

}