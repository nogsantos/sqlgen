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

        String sql = new Sql().select("customer", "cus").build();


        return new ResponseEntity<>(
                sql,
                HttpStatus.OK);
    }
}
