package cn.lhz.springbootredissingle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootRedisSingleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisSingleApplication.class, args);
    }

}
