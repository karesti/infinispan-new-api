package org.infinispan.api.v1.collection.map;

import org.infinispan.api.v1.admistration.Configuration;

public class MapConfig implements Configuration {
   private final String name;

   public MapConfig(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
