package com.infosystem.dynamicDatabase.metaTablesMethods;

import static com.infosystem.dynamicDatabase.constant.ConnectorData.DB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.infosystem.dynamicDatabase.connection.ConnectionStatus;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;

public class CreateMetatables {
	public static void create() {
		String[] sql = { "/meta_tables.sql", "/meta_columns.sql", "/index.sql",
				"/add_foreign_key.sql" };
		for (String string : sql) {
			InputStream is = Class.class.getResourceAsStream(string);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuffer sb = new StringBuffer();
			try {
				while (br.ready()) {
					sb.append(br.readLine());
				}
				MaintainConnection.connectLocalhost(DB);
				ConnectionStatus.getInstance().getStatement()
						.executeUpdate(sb.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
