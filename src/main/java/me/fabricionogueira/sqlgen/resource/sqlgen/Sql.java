package me.fabricionogueira.sqlgen.resource.sqlgen;

import me.fabricionogueira.sqlgen.resource.sqlgen.exceptions.IsRequiredException;
import me.fabricionogueira.sqlgen.resource.sqlgen.select.Select;

public class Sql {

    private String query_table;

    public Select select(String table, String alias) {
        this.query_table = table;

        this.validateRequired();

        return new Select(table, alias);
    }

    private void validateRequired() {
        if (this.query_table.isEmpty()) {
            throw new IsRequiredException("Table is required");
        }
    }

}
