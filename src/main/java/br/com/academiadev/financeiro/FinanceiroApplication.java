package br.com.academiadev.financeiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class FinanceiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceiroApplication.class, args);
    }
}
