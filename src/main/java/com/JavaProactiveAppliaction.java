package com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/4 9:06
 * @Description:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class JavaProactiveAppliaction {
    public static void main(String[] args) {
        SpringApplication.run(JavaProactiveAppliaction.class, args);
        log.info("info启动JavaProactiveAppliaction成功");
        log.info("测试log4j2日志打印状态：http://127.0.0.1:8081/log/test");
    }
}
