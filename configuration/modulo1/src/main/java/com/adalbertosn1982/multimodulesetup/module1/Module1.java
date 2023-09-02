package com.adalbertosn1982.multimodulesetup.module1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Module1 {
    public static void main(String[] args) {
        log.info("======== Begin run Execute Module1 =========");
        SpringApplication.run(Module1.class, args);
    }

    public static void printInfo() {
        log.info("======== Begin run Execute Module1 =========");
        /*
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

         */
    }

    @Bean
    public CommandLineRunner memInfoRunner() {
        return args -> printInfo();
    }
}
