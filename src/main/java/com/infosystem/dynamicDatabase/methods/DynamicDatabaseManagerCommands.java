package com.infosystem.dynamicDatabase.methods;

import java.util.List;
import java.util.Map;

import com.infosystem.dynamicDatabase.DynamicDatabaseManager;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class DynamicDatabaseManagerCommands implements DynamicDatabaseManager {

	public String create(TableDefinition tableDefinition) {
		StringBuilder sqlCommand = new StringBuilder();
		sqlCommand.append("CREATE TABLE ");
		sqlCommand.append(tableDefinition.getId() + " (\n");
		sqlCommand.append("id INT NOT NULL AUTO_INCREMENT, \n");
		List<ColumnDefinition> listaKolumn = tableDefinition.getColumnList();
		for (ColumnDefinition columnDefinition : listaKolumn) {
			sqlCommand.append(columnDefinition.getId() + " ");
			switch (columnDefinition.getDataType()) {
			case NUMBER:
				sqlCommand.append("INT (255) ");
				break;
			case STRING:
				sqlCommand.append("VARCHAR (255) ");
				break;
			case DATE:
				sqlCommand.append("DATE ");
				break;
			case PREDEFINED_VALUE:
				sqlCommand.append("VARCHAR (255) ");
				break;
			case SUB_SET:
				sqlCommand.append("DATE ");
				break;
			default:
				sqlCommand.append("VARCHAR (255) ");
				break;
			}
			sqlCommand.append(columnDefinition.getColumnDef() + ", \n");

			// co z labelami?
		}
		sqlCommand.append("PRIMARY KEY ( id )\n);");
		return sqlCommand.toString();
	}

	public String deleteTable(String tableId) {
		StringBuilder sb = new StringBuilder();
		sb.append("DROP TABLE ");
		sb.append(tableId);
		return sb.toString();
	}

	public String existsTable(String tableId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT 1 FROM ");
		sb.append(tableId);
		sb.append(" LIMIT 1");
		return sb.toString();
	}

	public String insertDataRow(DataRow row) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(row.getTableId() + " ( ");
		Map<String, DataHolder> dataHolder = row.getData();
		// skąd wziąć nazwy kolumn które mamy updatować?

		sb.append(" )\nVALUES\n( ");
		for (int i = 0; i < dataHolder.size(); i++) {
			sb.append(dataHolder.get(i).getString() + ", ");
		}
		sb.substring(0, sb.length() - 2);
		sb.append(" )");
		return sb.toString();
	}

	public String getDataRows(QueryParams queryParams) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		List<String> columnList = queryParams.getColumnList();
		for (String column : columnList) {
			sb.append(column + ", ");
		}
		sb.substring(0, sb.length() - 2);
		sb.append(" FROM ");
		sb.append(queryParams.getTableId());
		sb.append("WHERE ");

		// do filter interface interpreter
		sb.append(queryParams.getFilter());
		sb.append(" ORDER BY ");
		List<String> sortColumns = queryParams.getSortColumns();
		for (String column : sortColumns) {
			sb.append(column + ", ");
		}
		sb.substring(0, sb.length() - 2);
		sb.append(" LIMIT ");
		sb.append(queryParams.getFirstResult());
		sb.append(", ");
		sb.append(queryParams.getResultCount());
		return sb.toString();
	}

	public String deleteDataRow(String tableId, Long rowId) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(tableId);
		sb.append(" WHERE id=");
		sb.append(rowId);
		return sb.toString();
	}

	public String updateDataRow(DataRow row) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(row.getTableId());
		sb.append("\n SET ");
		Map<String, DataHolder> data = row.getData();
		for (Map.Entry<String, DataHolder> entry : data.entrySet()) {
			sb.append(entry.getKey().toString());
			sb.append(" = ");
			sb.append(entry.getValue().getString());
		}
		sb.append("\n WHERE id=");
		sb.append(row.getRowId());
		sb.toString();
		return sb.toString();
	}
}