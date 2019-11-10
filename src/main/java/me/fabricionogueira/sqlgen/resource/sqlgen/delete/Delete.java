package me.fabricionogueira.sqlgen.resource.sqlgen.delete;

public class Delete {

    private String table;
    private String schema;

    public Delete(String table, String schema) {
        this.table = table;
        this.schema = schema;
    }

}
