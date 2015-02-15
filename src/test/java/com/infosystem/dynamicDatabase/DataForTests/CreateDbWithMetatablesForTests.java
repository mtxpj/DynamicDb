package com.infosystem.dynamicDatabase.DataForTests;

import static com.infosystem.dynamicDatabase.DataForTests.DataForTests.TEST_DB_NAME;
import static com.infosystem.dynamicDatabase.metaTablesMethods.CreateMetatables.setDatabaseWithMetatables;

public class CreateDbWithMetatablesForTests {

	void prepare() {
		setDatabaseWithMetatables(TEST_DB_NAME);
	}
}
