package com.yimning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*用于扫描mapper,否则会找不到*/
@MapperScan("com.yimning.mapper")
/*@ComponentScan(basePackages = {"com.yimning"})*/
@SpringBootApplication
public class YimningApplication {

    public static void main(String[] args) {
        SpringApplication.run(YimningApplication.class, args);
    }

}
