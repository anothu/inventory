package indi.me.inventory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "indi.me.inventory.mapper")
@ComponentScan(value = "indi.me.inventory.Frame")
@ComponentScan(value = "indi.me.inventory.service")
public class InventoryApplication {


    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);

    }


}
