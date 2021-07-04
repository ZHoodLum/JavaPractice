package com.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/4 11:49
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/log")
public class Log4j2Controller {
//    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public String test() {
        log.info("你好, helloworld");
        log.warn("你好, helloworld");
        log.debug("你好, helloworld");
        log.error("你好, helloworld");
        return "你好, helloworld";
    }
}
