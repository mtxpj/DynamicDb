package com.infosystem.dynamicDatabase;

import com.infosystem.dynamicDatabase.model.DataRow;
import com.infosystem.dynamicDatabase.model.QueryParams;
import com.infosystem.dynamicDatabase.model.TableDefinition;

public interface DynamicDatabaseManager {

    /**
     * @param tableDefinition
     * @return null if operation is succesful, errorDescription if operation
     *         failed;
     */
    public String create(TableDefinition tableDefinition);

    /**
     * @param tableId
     * @return true if delete was succesful
     */
    public String deleteTable(String tableId);

    /**
     * @param tableId
     * @return true if table exsits in warehouse
     */
    public String existsTable(String tableId);

    /**
     * @param row
     * @return id of created row if it was not provided
     */
    public String insertDataRow(DataRow row);

    /**
     * @param queryParams
     * @return list rows which fullfill QueryParams criteria
     */
    public String getDataRows(QueryParams queryParams);

    /**
     * @param tableId
     * @param rowId
     * @return
     */
    public String deleteDataRow(String tableId, Long rowId);

    /**
     * Udpates row
     * @param row
     * @return 
     */
    public String updateDataRow(DataRow row);

}
