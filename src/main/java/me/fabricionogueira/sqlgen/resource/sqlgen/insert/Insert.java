package me.fabricionogueira.sqlgen.resource.sqlgen.insert;

public class Insert {
    private String table;
    private String schema;

    public Insert(String table, String schema) {
        this.table = table;
        this.schema = schema;
    }
}
