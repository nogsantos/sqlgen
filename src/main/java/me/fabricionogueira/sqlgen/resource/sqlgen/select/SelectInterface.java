package me.fabricionogueira.sqlgen.resource.sqlgen.select;

interface SelectInterface {
    Select join(String join_table, String join_alias, String join_target);

    Select join(String join_table, String join_alias, String join_target, String operation);

    Select columns(String... columns);
}
