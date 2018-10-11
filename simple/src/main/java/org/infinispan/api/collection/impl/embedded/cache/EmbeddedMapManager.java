package org.infinispan.api.collection.impl.embedded.cache;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.infinispan.api.collection.cache.Cache;
import org.infinispan.api.collection.cache.CacheConfig;
import org.infinispan.api.collection.cache.CacheManager;


public class EmbeddedMapManager implements CacheManager {


   @Override
   public CompletionStage<Boolean> defineCacheConfig(CacheConfig configuration) {
      return CompletableFuture.completedFuture(true);
   }

   @Override
   public <K, V> Cache<K, V> getOrCreate(String name) {
      return new EmbeddedAsyncCache<>();
   }

   @Override
   public <K, V> Cache<K, V> getOrCreate(String name, String configName) {
      return new EmbeddedAsyncCache<>();
   }

   @Override
   public <K, V> Cache<K, V> getOrCreate(String name, CacheConfig config) {
      return new EmbeddedAsyncCache<>();
   }
}
