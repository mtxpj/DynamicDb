package com.infosystem.dynamicDatabase.connection;

public class MaintainConnection {

	public static void connect(String DB_NAME) {
		if (ConnectionStatus.connection == null) {
			LocalhostConnector.openConnection(DB_NAME);
		}
	}
}
