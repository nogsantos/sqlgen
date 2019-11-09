package me.fabricionogueira.sqlgen.resource.sqlgen.join;

public class Inner extends Join {

    public Inner(String query_alias, String table, String alias, String target_field) {
        super(query_alias, table, alias, target_field);
    }

    @Override
    public String toString() {
        return String.format(
                "inner join %s as %s on %s.%s = %s.%s",
                table,
                alias,
                query_alias,
                target_field,
                alias,
                target_field);
    }
}
