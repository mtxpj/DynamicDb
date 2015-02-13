package com.infosystem.dynamicDatabase;

import java.util.List;

import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public interface DynamicDatabaseManager {

    /**
     * @param tableDefinition
     * @return null if operation is successful, 
     * errorDescription if operation failed;
     */
    public String createOrUpdate(TableDefinition tableDefinition);

    /**
     * @param tableId
     * @return true if delete was successful
     */
    public boolean deleteTable(String tableId);

    /**
     * @param tableId
     * @return true if table exists in warehouse
     */
    public boolean existsTable(int tableKey);

    /**
     * @param row
     * @return id of created row if it was not provided
     */
    public Long insertDataRow(DataRow row);

    /**
     * @param queryParams
     * @return list rows which fulfill QueryParams criteria
     */
    public List<DataRow> getDataRows(QueryParams queryParams);

    /**
     * @param tableId
     * @param rowId
     * @return
     */
    public boolean deleteDataRow(String tableId, Long rowId);

    /**
     * Updates row
     * @param row
     */
    public void updateDataRow(DataRow row);

}
