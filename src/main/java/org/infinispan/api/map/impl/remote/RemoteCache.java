package org.infinispan.api.map.impl.remote;

import java.util.HashMap;
import java.util.Map;

import org.infinispan.api.map.InfinispanMap;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;

public class RemoteCache<K, V> implements InfinispanMap<K, V> {

   private Map<K, V> map = new HashMap();

   private Configuration configuration;

   public RemoteCache() {
      this(new ConfigurationBuilder().build());
   }

   public RemoteCache(Configuration configuration) {
      this.configuration = configuration;
   }

   @Override
   public void put(K key, V value) {
      map.put(key, value);
   }

   @Override
   public V get(K key) {
      return map.get(key);
   }
}