package com.infosystem.dynamicDatabase.SqlBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.infosystem.dynamicDatabase.methods.GetColumnNames;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.Sort;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public class SqlBuilder {

	public static String createOrUpdate(TableDefinition tableDefinition) {

		StringBuilder sqlCommand = new StringBuilder();
		sqlCommand.append("CREATE TABLE ");
		sqlCommand.append(tableDefinition.getId() + " (\n");
		sqlCommand.append("id INT NOT NULL AUTO_INCREMENT,\n");
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
		System.out.println(sqlCommand.toString());
		return sqlCommand.toString();
	}

	public static String deleteTable(String tableId) {
		StringBuilder sb = new StringBuilder();
		sb.append("DROP TABLE ");
		sb.append(tableId);
		sb.append(" ;");
		return sb.toString();
	}

	public static String existsTable(String tableId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT 1 FROM ");
		sb.append(tableId);
		sb.append(" LIMIT 1");
		sb.append(" ;");
		return sb.toString();
	}

	public static String insertDataRow(DataRow row) {

		// deklaracja wiersza
		Map<String, DataHolder> dataHolder = row.getData();

		// wywołanie tabeli do którek wkładamy
		StringBuilder sqlCommand = new StringBuilder();
		sqlCommand.append("INSERT INTO ");
		sqlCommand.append(row.getTableId());

		// wywołanie listy kolumn
		sqlCommand.append(" ( ");
		ArrayList<String> columnList = GetColumnNames.fromMetaData(row.getTableId());
		for (String string : columnList) {
			sqlCommand.append(string + ", ");
		}
		
		// przycięcie listy kolumn
		String substring = sqlCommand.substring(0, (sqlCommand.length() - 2));
		sqlCommand = new StringBuilder();
		sqlCommand.append(substring);
		sqlCommand.append(" )");

		// podanie wartości dla kolumn
		sqlCommand.append("\nVALUES ( ");
		Random random = new Random();
		int val = random.nextInt(100);
		sqlCommand.append((row.getRowId() + val) + ", ");
		for (int i = 0; i < dataHolder.size(); i++) {
			String column = columnList.get(i + 1); // i+1 żeby ominąć kolumnę 'id'									
			switch (dataHolder.get(column).getDataType()) {
			case NUMBER:
				sqlCommand.append(dataHolder.get(column).getNumber() + ", ");
				break;
			case DATE:
				sqlCommand.append(dataHolder.get(column).getDate() + ", ");
				break;
			case STRING:
				sqlCommand.append(dataHolder.get(column).getString() + ", ");
				break;
			case PREDEFINED_VALUE:
				sqlCommand.append(dataHolder.get(column).getBool() + ", ");
				break;
			case SUB_SET:
				break;
			}
		}

		// przyciecie wartosci
		substring = sqlCommand.substring(0, (sqlCommand.length() - 2));
		sqlCommand = new StringBuilder();
		sqlCommand.append(substring);
		sqlCommand.append(" );");

		// wydruk komendy i zwrot
		System.out.println(sqlCommand.toString());
		return sqlCommand.toString();
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
		List<Sort> sortColumns = queryParams.getSortColumns();
		for (Sort column : sortColumns) {
			sb.append(column + ", ");
		}
		sb.substring(0, sb.length() - 2);
		sb.append(" LIMIT ");
		sb.append(queryParams.getFirstResult());
		sb.append(", ");
		sb.append(queryParams.getResultCount());
		return sb.toString();
	}

	public static String deleteDataRow(String tableId, Long rowId) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(tableId);
		sb.append(" WHERE id=");
		sb.append(rowId);
		sb.append(" ;");
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
