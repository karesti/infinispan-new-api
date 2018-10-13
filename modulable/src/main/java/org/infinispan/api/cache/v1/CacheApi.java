package org.infinispan.api.cache.v1;

import java.util.function.Function;

import org.infinispan.api.Api;

public class CacheApi<K, V> implements Api<Cache<K, V>, CacheConfig> {

   private static final CacheApi INSTANCE = new CacheApi();

   private CacheApi() {
   }

   public static <K, V> CacheApi<K, V> instance() {
      return INSTANCE;
   }

   @Override
   public <F extends Function<CacheConfig, Cache<K, V>>> Class<F> classApi() {
      return (Class) Cache.Factory.class;
   }

}
