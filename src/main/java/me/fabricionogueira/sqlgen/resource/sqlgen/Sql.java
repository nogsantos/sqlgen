package me.fabricionogueira.sqlgen.resource.sqlgen;

import me.fabricionogueira.sqlgen.resource.sqlgen.exceptions.IsRequiredException;
import me.fabricionogueira.sqlgen.resource.sqlgen.join.*;

public class Sql implements Buildable {

    private String query_table;
    private String query_alias;
    private String select_statement;
    private String columns_statement;
    private String join_statement = "";


    public Sql select(String table, String alias) {
        this.query_table = table;
        this.query_alias = alias;

        this.validateRequired();

        Select sql = new Select(table, alias);
        this.select_statement = sql.toString();
        return this;
    }

    public Sql columns(String... columns) {
        Columns sql = new Columns(this.query_alias, columns);
        this.columns_statement = sql.toString();
        return this;
    }

    private void validateRequired() {
        if (this.query_table.isEmpty()) {
            throw new IsRequiredException("Table is required");
        }
    }

    public Sql join(String table, String alias, String target) {
        Join join = new Inner(this.query_alias, table, alias, target);
        this.join_statement += " " + join.toString();
        return this;
    }

    public Sql join(String table, String alias, String target, String operation) {
        if (operation.isEmpty()) {
            throw new IsRequiredException("Operation is empty");
        }

        Join joinQuery;

        switch (operation) {
            case "left":
                joinQuery = new Left(this.query_alias, table, alias, target);
                break;
            case "cross":
                joinQuery = new Cross(this.query_alias, table, alias, target);
                break;
            case "right":
                joinQuery = new Right(this.query_alias, table, alias, target);
                break;
            default:
                joinQuery = new Inner(this.query_alias, table, alias, target);
                break;
        }
        this.join_statement += " " + joinQuery.toString();
        return this;
    }


    @Override
    public String build() {
        String output = "";
        if (this.select_statement != null && !this.select_statement.isEmpty()) {
            output = String.format(
                    "select %s from %s",
                    this.columns_statement,
                    this.select_statement
            );

            if (this.join_statement != null && !this.join_statement.isEmpty()) {
                output += String.format(
                        "%s",
                        this.join_statement
                );
            }
        }

        return output.trim();
    }


}
