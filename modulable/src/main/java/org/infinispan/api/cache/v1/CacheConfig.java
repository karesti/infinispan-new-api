package org.infinispan.api.cache.v1;

public class CacheConfig {
   private final String name;

   public CacheConfig(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }
}
