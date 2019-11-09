package me.fabricionogueira.sqlgen.resource.sqlgen;

public class Select {

    private String table;
    private String alias;

    public Select(String table, String alias) {
        this.table = table;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return String.format("%s as %s", table, alias);
    }
}
