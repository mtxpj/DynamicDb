package com.infosystem.dynamicDatabase.SuiteClasses;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.infosystem.dynamicDatabase.DataForTests.DataForTests;
import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.dbStructure.ColumnManagerTest;
import com.infosystem.dynamicDatabase.dbStructure.DbManagerTest;
import com.infosystem.dynamicDatabase.dbStructure.TableManagerTest;

@RunWith(Suite.class)
@SuiteClasses({ DbManagerTest.class, ColumnManagerTest.class,
		TableManagerTest.class })
public class AllLocalhostTest {
	@BeforeClass
	public static void method() {
		MaintainConnection.connectLocalhostWithUserAndPassword(DataForTests.getTestDb());

	}
}
