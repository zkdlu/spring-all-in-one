package com.zkdlu.metric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class MetricApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetricApplication.class, args);
    }

    @Bean
    public InMemoryAuditEventRepository repository() {
        return new InMemoryAuditEventRepository();
    }

    @Bean
    HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }

    @Scheduled(fixedDelay = 1000)
    void scheduledJob() {
        System.out.println("hello");
    }
}
