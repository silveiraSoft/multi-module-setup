package com.adalbertosn1982.multimodulesetup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.management.ManagementFactory;
import java.text.NumberFormat;


@SpringBootApplication(scanBasePackages = "com.adalbertosn1982.*")
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }, scanBasePackages = "com.adalbertosn1982.*")
@Slf4j
//@ComponentScan(basePackages = {"com.adalbertosn1982.*"})
//@EntityScan(basePackages = {"com.adalbertosn1982.*"})
//@EnableJpaRepositories(basePackages = {"com.adalbertosn1982.*"})
public class MultiModuleSetupApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiModuleSetupApplication.class, args);
    }

    /**
     * Metodo que imprime la informacion de memoria que inicia usando la aplicacion en el
     * contenedor.
     */
    public static void printInfo() {
        Runtime runtime = Runtime.getRuntime();

        final NumberFormat format = NumberFormat.getInstance();
        final long maxMemory = runtime.maxMemory();
        final long allocatedMemory = runtime.totalMemory();
        final long freeMemory = runtime.freeMemory();
        final long mb = 1024L * 1024L;
        final String mega = " MB";

        log.info("========================== Memory Info ==========================");
        log.info("name = " + ManagementFactory.getRuntimeMXBean().getName());
        log.info("Free memory: " + format.format(freeMemory / mb) + mega);
        log.info("Allocated memory: " + format.format(allocatedMemory / mb) + mega);
        log.info("Max memory: " + format.format(maxMemory / mb) + mega);
        log.info("Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + mega);
        log.info("=================================================================");
    }

    @Bean
    public CommandLineRunner memInfoRunner() {
        return args -> printInfo();
    }

}
