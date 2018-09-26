package org.infinispan.api;

import org.infinispan.configuration.cache.Configuration;

public interface CacheManager<K, V> {

   <K, V> Cache<K, V> getCache();

   <K, V> Cache<K, V> getCache(Configuration configuration);
}
