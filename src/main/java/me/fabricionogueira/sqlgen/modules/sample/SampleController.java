package me.fabricionogueira.sqlgen.modules.sample;

import me.fabricionogueira.sqlgen.resource.sqlgen.Sql;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SampleController {

    @GetMapping("/")
    public ResponseEntity<String> sample() {
        String sql = new Sql()
                .select("pessoa", "pes")
                .columns("pes", "vei.placa")
                .join("veiculo", "vei", "rg")
                .build();

        String body = "<h1>Fabricio Nogueira</h1>";
        body += "<h2>The Instruction</h2>";
        body += "<pre>";
        body +="new Sql().select(\"pessoa\", \"pes\").columns(\"pes\", \"vei.placa\").join(\"veiculo\", \"vei\", \"rg\").build()";
        body += "</pre>";
        body += "<h2>Results the string</h2>";
        body += "<pre>";
        body += sql;
        body += "</pre>";

        return new ResponseEntity<>(
                body,
                HttpStatus.OK);
    }
}
