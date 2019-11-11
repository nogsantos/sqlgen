package me.fabricionogueira.sqlgen.resource.sqlgen.select.join;

public class Cross extends Join {

    public Cross(String alias, String compare_table, String compare_alias, String target_field) {
        super(alias, compare_table, compare_alias, target_field);
    }

    @Override
    public String toString() {
        return String.format(
                "cross join %s as %s on %s.%s = %s.%s",
                this.compare_table,
                this.compare_alias,
                this.alias,
                this.target_field,
                this.compare_alias,
                this.target_field
        );
    }
}
