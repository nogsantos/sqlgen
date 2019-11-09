package me.fabricionogueira.sqlgen.resource.sqlgen;

public class Columns {

    private String cols;

    Columns(String alias, String... columns) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String column : columns) {

            if (!alias.isEmpty() && column.equals(alias)) {
                stringBuilder.append(alias);
                stringBuilder.append(".");
                stringBuilder.append("*");
            } else if (column.contains(".")) {
                stringBuilder.append(column);
            } else {
                stringBuilder.append(alias);
                stringBuilder.append(".");
                stringBuilder.append(column);
            }
            stringBuilder.append(", ");
        }
        cols = stringBuilder.toString().substring(0, stringBuilder.length() - 2);
    }


    @Override
    public String toString() {
        return cols;
    }
}
