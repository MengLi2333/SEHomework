package cn.edu.cuit.hdhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.edu.cuit.hdhr.mapper")
@SpringBootApplication
public class HdhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(HdhrApplication.class, args);
    }

}
