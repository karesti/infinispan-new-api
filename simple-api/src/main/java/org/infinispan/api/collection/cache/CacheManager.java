package org.infinispan.api.collection.cache;

import java.util.concurrent.CompletionStage;

public interface CacheManager {

   CompletionStage<Boolean> defineCacheConfig(CacheConfig configuration);

   // Will use default configuration
   <K, V> Cache<K, V> getOrCreate(String name);

   // Will use defined configuration
   <K, V> Cache<K, V> getOrCreate(String name, String configName);

   // Will use a given configuration
   <K, V> Cache<K, V> getOrCreate(String name, CacheConfig config);

}
