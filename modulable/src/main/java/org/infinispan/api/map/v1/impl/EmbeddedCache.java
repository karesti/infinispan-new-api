package org.infinispan.api.map.v1.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import org.infinispan.api.map.v1.Cache;
import org.infinispan.api.map.v1.CacheConfig;
import org.kohsuke.MetaInfServices;


public class EmbeddedCache<K,V> implements Cache<K, V> {

   private final Queue<String> queue = new LinkedList<>();
   private final Map<K, V> data = new HashMap<>();
   private CacheConfig config;

   private EmbeddedCache(CacheConfig config) {
      this.config = config;
   }

   public V get(K key) {
      queue.offer("[map-v1-embedded] GET key=" + key);
      return data.get(key);
   }

   public V put(K key, V value) {
      queue.offer("[map-v1-embedded] PUT key=" + key + ",value=" + value);
      return data.put(key, value);
   }

   @Override
   public String getName() {
      return config.getName();
   }

   @Override
   public String toString() {
      return queue.stream().collect(Collectors.joining("\n"));
   }

   @MetaInfServices
   public final static class FactoryImpl<K, V> implements Cache.Factory<K, V> {

      @Override
      public Cache<K, V> apply(CacheConfig config) {
         return new EmbeddedCache<>(config);
      }
   }
}