package me.fabricionogueira.sqlgen.resource.sqlgen.join;

public abstract class Join {

    protected String query_alias;
    protected String table;
    protected String alias;
    protected String target_field;

    public Join(String query_alias, String table, String alias, String target_field) {
        this.query_alias = query_alias;
        this.table = table;
        this.alias = alias;
        this.target_field = target_field;
    }
}
