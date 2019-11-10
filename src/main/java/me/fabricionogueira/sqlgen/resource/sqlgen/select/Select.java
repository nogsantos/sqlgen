package me.fabricionogueira.sqlgen.resource.sqlgen.select;

import me.fabricionogueira.sqlgen.resource.sqlgen.Buildable;
import me.fabricionogueira.sqlgen.resource.sqlgen.select.join.*;

public class Select implements SelectInterface, Buildable {

    private String table;
    private String alias;
    private String join_statement = "";
    private Columns columns_statement;

    public Select(String table, String alias) {
        this.table = table;
        this.alias = alias;
    }

    @Override
    public Select join(String join_table, String join_alias, String join_target) {
        Join joinQuery = new Inner(this.alias, join_table, join_alias, join_target);
        this.join_statement += " " + joinQuery.toString();

        return this;
    }

    @Override
    public Select join(String join_table, String join_alias, String join_target, String operation) {
        Join joinQuery;

        switch (operation) {
            case "left":
                joinQuery = new Left(this.alias, join_table, join_alias, join_target);
                break;
            case "cross":
                joinQuery = new Cross(this.alias, join_table, join_alias, join_target);
                break;
            case "right":
                joinQuery = new Right(this.alias, join_table, join_alias, join_target);
                break;
            default:
                joinQuery = new Inner(this.alias, join_table, join_alias, join_target);
                break;
        }
        this.join_statement += " " + joinQuery.toString();

        return this;
    }

    @Override
    public Select columns(String... columns) {
        this.columns_statement = new Columns(this.alias, columns);
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s as %s", table, alias);
    }

    @Override
    public String build() {
        String output = String.format(
                "select %s from %s as %s",
                columns_statement.toString(),
                table,
                alias
        );

        if (join_statement != null && !join_statement.isEmpty()) {
            output += String.format(
                    "%s",
                    join_statement
            );
        }
        return output.trim();
    }
}
