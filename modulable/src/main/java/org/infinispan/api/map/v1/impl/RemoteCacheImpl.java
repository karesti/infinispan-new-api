package org.infinispan.api.map.v1.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.infinispan.api.map.v1.CacheConfig;
import org.infinispan.api.map.v1.RemoteCache;
import org.kohsuke.MetaInfServices;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;


public class RemoteCacheImpl<K, V> implements RemoteCache<K, V> {

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
   public CompletionStage<V> getAndPut(K key, V value) {
      return CompletableFuture.completedFuture(data.put(key, value));
   }

   private static final class PublisherFromStream<T> implements Publisher<T> {
      private final Stream<T> stream;

      private PublisherFromStream(Stream<T> stream) {
         this.stream = stream;
      }

      @Override
      public void subscribe(Subscriber<? super T> s) {
         stream.forEach(val -> s.onNext(val));
         s.onComplete();
      }
   }

   @Override
   public Publisher<K> getKeys() {
      return new PublisherFromStream<>(this.data.keySet().stream());
   }

   @Override
   public Publisher<V> getValues() {
      return new PublisherFromStream<>(this.data.values().stream());
   }

   @Override
   public CompletionStage<Void> putMany(Map<K, V> map) {
      data.putAll(map);
      return CompletableFuture.completedFuture(null);
   }

   @Override
   public CompletionStage<Void> putMany(Publisher<Map.Entry<K, V>> pairs) {
      return null;
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