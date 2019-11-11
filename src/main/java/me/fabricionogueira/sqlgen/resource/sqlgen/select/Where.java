package me.fabricionogueira.sqlgen.resource.sqlgen.select;

import me.fabricionogueira.sqlgen.resource.sqlgen.genenral.where.And;
import me.fabricionogueira.sqlgen.resource.sqlgen.genenral.where.Or;

public class Where implements And, Or {

    private String condition;

    public Where(String condition) {
        this.condition = condition;
    }

    @Override
    public void and(String conditions) {
        this.condition += String.format(" and %s", conditions);
    }

    @Override
    public void or(String conditions) {
        this.condition += String.format(" or %s", conditions);
    }

    @Override
    public String toString() {
        return String.format(" where %s ", this.condition);
    }
}
