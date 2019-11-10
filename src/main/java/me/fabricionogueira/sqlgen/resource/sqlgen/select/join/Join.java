package me.fabricionogueira.sqlgen.resource.sqlgen.select.join;

public abstract class Join {

    protected String alias;
    protected String compare_table;
    protected String compare_alias;
    protected String target_field;

    public Join(String alias, String compare_table, String compare_alias, String target_field) {
        this.alias = alias;
        this.compare_table = compare_table;
        this.compare_alias = compare_alias;
        this.target_field = target_field;
    }
}
