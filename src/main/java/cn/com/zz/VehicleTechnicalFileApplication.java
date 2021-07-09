package cn.com.zz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;


@MapperScan({"cn.com.zz.mapper","cn.com.zz.dao"})
@EnableOpenApi
@SpringBootApplication
public class VehicleTechnicalFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleTechnicalFileApplication.class, args);
    }

}
