package com.diplo.diplo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
   prefix = "info.swagger"
)
public class SwaggerInfoProperties {
   private String description;
   private String ui;
   private String apiDocs;

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getUi() {
      return this.ui;
   }

   public void setUi(String ui) {
      this.ui = ui;
   }

   public String getApiDocs() {
      return this.apiDocs;
   }

   public void setApiDocs(String apiDocs) {
      this.apiDocs = apiDocs;
   }
}
