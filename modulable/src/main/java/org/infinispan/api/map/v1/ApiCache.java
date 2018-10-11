package org.infinispan.api.map.v1;

import java.util.function.Function;

import org.infinispan.api.Api;

public class ApiCache<K, V> implements Api<Cache<K, V>, CacheConfig> {

   private static final ApiCache INSTANCE = new ApiCache();

   private ApiCache() {
   }

   public static <K, V> ApiCache<K, V> instance() {
      return INSTANCE;
   }

   @Override
   public Location location() {
      return Location.ANYWHERE;
   }

   @Override
   public <F extends Function<CacheConfig, Cache<K, V>>> Class<F> classApi() {
      return (Class) Cache.Factory.class;
   }

}
