package com.diplo.diplo.config;

import java.util.Map;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.stereotype.Component;

@Component
public class SwaggerInfoContributor implements InfoContributor {
   private final SwaggerInfoProperties properties;
   private String javaVersion = System.getProperty("java.version");
   private String springBootVersion = SpringBootVersion.getVersion();

   public SwaggerInfoContributor(SwaggerInfoProperties properties) {
      this.properties = properties;
   }

   public void contribute(Builder builder) {
      builder.withDetail("app", Map.of("Spring Boot Version", this.springBootVersion, "Java version", this.javaVersion));
      builder.withDetail("swagger", Map.of("description", this.properties.getDescription(), "ui", this.properties.getUi(), "api-docs", this.properties.getApiDocs()));
   }
}