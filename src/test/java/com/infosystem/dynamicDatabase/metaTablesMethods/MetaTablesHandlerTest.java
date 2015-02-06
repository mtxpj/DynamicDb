package com.infosystem.dynamicDatabase.metaTablesMethods;

import org.junit.Test;

import com.infosystem.dynamicDatabase.DataForTests.SampleTableDefinitionProvider;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class MetaTablesHandlerTest {

	@Test
	public void testCreateOrUpdate() {
		// given
		TableDefinition td = SampleTableDefinitionProvider
				.createSampleTableDefinition(10);

		// when

		// than
		// create
		MetaTablesHandler.createOrUpdate(td);
		// assert
		// read
		// ass
		// update
		// ass
		// del
		// ass
	}

}
