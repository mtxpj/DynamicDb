package com.infosystem.dynamicDatabase.modelMethods;

import java.util.List;

import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class TableDefinitionManager {
	
	public TableDefinition createTableDefinition(String id,
			List<ColumnDefinition> cd) {
		TableDefinition td = new TableDefinition();
		td.setId(id);
		td.setColumnList(cd);
		return td;
	}
}
