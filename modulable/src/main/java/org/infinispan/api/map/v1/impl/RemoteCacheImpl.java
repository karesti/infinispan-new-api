package org.infinispan.api.map.v1.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.infinispan.api.map.v1.CacheConfig;
import org.infinispan.api.map.v1.RemoteCache;
import org.kohsuke.MetaInfServices;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;


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
   public CompletionStage<Void> put(K key, V value, long lifespan, TimeUnit unit) {
      return put(key, value);
   }

   @Override
   public CompletionStage<Void> put(K key, V value, long lifespan, TimeUnit lifepanUnit, long maxidle, TimeUnit maxidleUnit) {
      return put(key, value);
   }

   @Override
   public Flow.Publisher<K> getKeys() {
      SubmissionPublisher publisher = new SubmissionPublisher<K>();
      data.keySet().stream().forEach(i -> publisher.submit(i));
      publisher.close();
      return publisher;
   }

   @Override
   public Flow.Publisher<V> getValues() {
      SubmissionPublisher publisher = new SubmissionPublisher<V>();
      data.values().stream().forEach(i -> publisher.submit(i));
      publisher.close();
      return publisher;
   }

   @Override
   public String getName() {
      return config.getName();
   }

   @Override
   public CompletionStage<Long> size() {
      return CompletableFuture.completedFuture(Long.valueOf(data.size()));
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