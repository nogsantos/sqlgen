package me.fabricionogueira.sqlgen;

import me.fabricionogueira.sqlgen.resource.sqlgen.Sql;
import me.fabricionogueira.sqlgen.resource.sqlgen.exceptions.IsRequiredException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
class SqlgenApplicationTests {

    @Test
    void it_should_generate_string_whit_sql_results_when_receive_basics_operations() {
        String sql = new Sql()
                .select("pessoa", "pes")
                .columns("pes", "vei.placa")
                .build();

        assertThat(sql, is(equalTo(
                "select pes.*, " +
                        "vei.placa " +
                        "from pessoa as pes"
        )));
    }

    @Test
    void it_should_throw_required_exception_when_user_do_not_inform_the_table() {
        assertThrows(IsRequiredException.class, () -> new Sql().select("", "").build());
    }

    @Test
    void it_should_create_inner_join_statement_when_operation_is_empty() {
        String sql = new Sql()
                .select("pessoa", "pes")
                .columns("pes", "vei.placa")
                .join("veiculo", "vei", "rg")
                .join("casa", "cas", "cpf")
                .build();
        assertThat(sql, is(equalTo(
                "select pes.*, " +
                        "vei.placa " +
                        "from pessoa as pes " +
                        "inner join veiculo as vei on pes.rg = vei.rg " +
                        "inner join casa as cas on pes.cpf = cas.cpf"
        )));
    }

    @Test
    void it_should_create_join_with_multiple_statement_when_operation_is_not_empty() {
        String sql = new Sql()
                .select("pessoa", "pes")
                .columns("pes", "vei.placa")
                .join("veiculo", "vei", "rg")
                .join("casa", "cas", "cpf", "left")
                .join("empresa", "emp", "cpf", "right")
                .join("estado", "est", "cpf", "cross")
                .build();
        assertThat(sql, is(equalTo(
                "select pes.*, " +
                        "vei.placa " +
                        "from pessoa as pes " +
                        "inner join veiculo as vei on pes.rg = vei.rg " +
                        "left join casa as cas on pes.cpf = cas.cpf " +
                        "right join empresa as emp on pes.cpf = emp.cpf " +
                        "cross join estado as est on pes.cpf = est.cpf"
        )));
    }

}
