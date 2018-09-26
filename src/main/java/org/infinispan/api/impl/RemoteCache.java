package org.infinispan.api.impl;

import org.infinispan.api.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;

public class RemoteCache<K, V> implements Cache<K, V> {

   private Configuration configuration;

   public RemoteCache() {
      this(new ConfigurationBuilder().build());
   }

   public RemoteCache(Configuration configuration) {
      this.configuration = configuration;
   }

   @Override
   public V put(K key, V value) {
      return null;
   }

   @Override
   public void putAndReturn(K key, V value) {

   }
}