package com.hanocybous.ecommercesystem.util;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Component
public class PrometheusMetricsExporter {

    private final PrometheusMeterRegistry prometheusMeterRegistry;

    @Autowired
    public PrometheusMetricsExporter(PrometheusMeterRegistry prometheusMeterRegistry) {
        this.prometheusMeterRegistry = prometheusMeterRegistry;
    }

    @Scheduled(fixedRate = 10000)  // Export metrics every 10 seconds
    public void exportMetrics() {
        String metrics = prometheusMeterRegistry.scrape();  // Get Prometheus metrics
        try {
            Files.write(Paths.get("src/main/resources/metrics.log"),
                    metrics.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
