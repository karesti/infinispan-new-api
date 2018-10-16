package org.infinispan.api.v1.collection.map;

public class MapConfig {
   private final String name;

   public MapConfig(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
