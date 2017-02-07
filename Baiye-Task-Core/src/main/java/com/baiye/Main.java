package com.baiye;


import com.baiye.config.CoreConfig;
import org.aeonbits.owner.ConfigFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by Baiye on 2017/1/17.
 */

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        /*CoreConfig coreConfig = ConfigFactory.create(CoreConfig.class);
        System.out.println(coreConfig.ip());*/
        SpringApplication.run(Main.class,args);
    }

}
