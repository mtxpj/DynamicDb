package com.infosystem.dynamicDatabase.SuiteClasses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.infosystem.dynamicDatabase.tablesTableSqlQuery.ColumnManagerSqlQueryTest;
import com.infosystem.dynamicDatabase.tablesTableSqlQuery.DbManagerSqlQueryTest;
import com.infosystem.dynamicDatabase.tablesTableSqlQuery.TablesTableManagerSqlQueryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ColumnManagerSqlQueryTest.class,
		DbManagerSqlQueryTest.class, TablesTableManagerSqlQueryTest.class })
public class AllSqlQueryTest {

}
