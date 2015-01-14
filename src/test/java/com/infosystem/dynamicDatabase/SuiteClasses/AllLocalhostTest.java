package com.infosystem.dynamicDatabase.SuiteClasses;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.infosystem.dynamicDatabase.connection.MaintainConnection;
import com.infosystem.dynamicDatabase.dbMetadata.ColumnManagerTest;
import com.infosystem.dynamicDatabase.dbMetadata.DbManagerTest;
import com.infosystem.dynamicDatabase.dbMetadata.MetaTableManagerTest;
import com.infosystem.dynamicDatabase.dbMetadata.Metadata;

@RunWith(Suite.class)
@SuiteClasses({ DbManagerTest.class, ColumnManagerTest.class,
		MetaTableManagerTest.class })
public class AllLocalhostTest {
	@BeforeClass
	public static void method() {
		MaintainConnection.connect(Metadata.getTestDb());

	}
}
