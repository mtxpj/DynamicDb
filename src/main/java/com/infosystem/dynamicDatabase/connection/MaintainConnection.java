package com.infosystem.dynamicDatabase.connection;

public class MaintainConnection {

	public static void connect(String db) {
		if (ConnectionStatus.connection == null) {
			LocalhostConnector.openConnection(db);
		}
	}
}
