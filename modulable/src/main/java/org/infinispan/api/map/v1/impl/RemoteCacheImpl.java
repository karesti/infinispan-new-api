package org.infinispan.api.map.v1.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import org.infinispan.api.map.v1.CacheConfig;
import org.infinispan.api.map.v1.RemoteCache;
import org.kohsuke.MetaInfServices;


public class RemoteCacheImpl<K,V> implements RemoteCache<K, V> {

   private final Queue<String> queue = new LinkedList<>();
   private final Map<K, V> data = new HashMap<>();
   private CacheConfig config;

   private RemoteCacheImpl(CacheConfig config) {
      this.config = config;
   }

   public CompletionStage<V> get(K key) {
      queue.offer("[map-v1-embedded] GET key=" + key);
      return CompletableFuture.completedFuture(data.get(key));
   }

   public CompletionStage<Void> put(K key, V value) {
      queue.offer("[map-v1-embedded] PUT key=" + key + ",value=" + value);
      data.put(key, value);
      return CompletableFuture.completedFuture(null);
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
   public final static class FactoryImpl<K, V> implements Factory<K, V> {

      @Override
      public RemoteCache<K, V> apply(CacheConfig config) {
         return new RemoteCacheImpl<>(config);
      }
   }
}