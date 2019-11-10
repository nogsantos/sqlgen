package me.fabricionogueira.sqlgen.resource.sqlgen.select.join;

public class Left extends Join {

    public Left(String alias, String compare_table, String compare_alias, String target_field) {
        super(alias, compare_table, compare_alias, target_field);
    }

    @Override
    public String toString() {
        return String.format(
                "left join %s as %s on %s.%s = %s.%s",
                compare_table,
                compare_alias,
                alias,
                target_field,
                compare_alias,
                target_field);
    }
}
