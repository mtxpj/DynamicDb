package com.infosystem.dynamicDatabase.SqlBuilder;

import static com.infosystem.dynamicDatabase.SqlBuilder.strategia.FabrykaStrategiiSqlowych.getStartegiaSqlowa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infosystem.dynamicDatabase.SqlBuilder.strategia.FabrykaStrategiiSqlowych;
import com.infosystem.dynamicDatabase.SqlBuilder.strategia.StrategiaSqlowa;
import com.infosystem.dynamicDatabase.model.ColumnDefinition;
import com.infosystem.dynamicDatabase.model.DataHolder;
import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.Sort;
import com.infosystem.dynamicDatabase.model.TableDefinition;
import com.infosystem.dynamicDatabase.modelMethods.GetColumnNames;

public class SqlBuilder {

	public static String createOrUpdate(TableDefinition tableDefinition) {
		StringBuilder sqlCommand = new StringBuilder();
		sqlCommand.append("CREATE TABLE IF NOT EXISTS ");
		sqlCommand.append(tableDefinition.getId());
		sqlCommand.append(" (\nid INT NOT NULL AUTO_INCREMENT,\n");
		List<ColumnDefinition> listaKolumn = tableDefinition.getColumnList();
		for (ColumnDefinition columnDefinition : listaKolumn) {
			sqlCommand.append(columnDefinition.getId() + " ");
			sqlCommand
					.append(getStartegiaSqlowa(columnDefinition.getDataType())
							.przygotujSqlDoTworzeniaKolumny());
			sqlCommand.append(new SyntaxCorrector()
					.getProperColumnDefinitionSyntax(columnDefinition.getColumnDef()) + ", \n");
		}
		sqlCommand.append("PRIMARY KEY ( id )\n) CHARSET=utf8;");
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
		Map<String, DataHolder> dataHolder = row.getData();
		StringBuilder sqlCommand = new StringBuilder();
		sqlCommand.append("INSERT INTO ");
		sqlCommand.append(row.getTableId());
		sqlCommand.append(" ( ");
		ArrayList<String> columnList = GetColumnNames.fromMetaData(row
				.getTableId());
		for (String string : columnList) {
			sqlCommand.append(string + ", ");
		}
		sqlCommand.substring(0, sqlCommand.length() - 2);
		sqlCommand.append(" )");
		sqlCommand.append("\nVALUES ( ");
		sqlCommand.append((row.getRowId()) + ", ");
		for (int i = 0; i < dataHolder.size(); i++) {
			String column = columnList.get(i + 1); // i+1 żeby ominąć kolumnę
			StrategiaSqlowa strategia = FabrykaStrategiiSqlowych
					.getStartegiaSqlowa(dataHolder.get(column).getDataType());
			sqlCommand
					.append(strategia
							.przygotujFragmentSQlZwiazanyZWstawianieWartosciDoInserta(dataHolder
									.get(column)));
		}
		sqlCommand.substring(0, sqlCommand.length() - 2);
		sqlCommand.append(" );");
		System.out.println(sqlCommand.toString());
		return sqlCommand.toString();
	}

	public static String getDataRows(QueryParams queryParams) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		System.out.println(queryParams.getColumnList().size());
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
		System.out.println("SqlBuilder.getDataRows:\n" + sb.toString());
		return sb.toString();
	}

	public static String deleteDataRow(String tableId, Long rowId) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(tableId);
		sb.append(" WHERE id=");
		sb.append(rowId);
		sb.append(";");
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

	public static String addForeignKey(String table, String column,
			String refTable, String refColumn) {
		StringBuilder sb = new StringBuilder();
		sb.append("ALTER TABLE ");
		sb.append(table);
		sb.append("\nADD FOREIGN KEY (");
		sb.append(column);
		sb.append(") REFERENCES ");
		sb.append(refTable);
		sb.append("(");
		sb.append(refColumn);
		sb.append(");");
		return sb.toString();
	}

}
