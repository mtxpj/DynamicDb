package com.infosystem.dynamicDatabase.SuiteClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.infosystem.dynamicDatabase.dbMetadataSqlQuery.ColumnManagerSqlQueryTest;
import com.infosystem.dynamicDatabase.dbMetadataSqlQuery.DbManagerSqlQueryTest;
import com.infosystem.dynamicDatabase.dbMetadataSqlQuery.MetaTableManagerSqlQueryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ColumnManagerSqlQueryTest.class,
		DbManagerSqlQueryTest.class, MetaTableManagerSqlQueryTest.class })
public class AllSqlQueryTest {

}
