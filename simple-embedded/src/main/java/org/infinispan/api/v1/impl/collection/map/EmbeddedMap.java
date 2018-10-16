package org.infinispan.api.v1.impl.collection.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.infinispan.api.v1.collection.map.MapConfig;
import org.infinispan.api.v1.collection.map.ReactiveMap;
import org.infinispan.api.v1.event.EventPublisher;
import org.infinispan.api.v1.reactive.IPublisher;
import org.kohsuke.MetaInfServices;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class EmbeddedMap<K, V> implements ReactiveMap<K, V>{

   private final Queue<String> queue = new LinkedList<>();
   private final Map<K, V> data = new HashMap<>();
   private MapConfig config;

   public EmbeddedMap(MapConfig config) {
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

   private static final class PublisherFromStream<T> implements Publisher {
      private final Stream<T> stream;

      private PublisherFromStream(Stream<T> stream) {
         this.stream = stream;
      }

      @Override
      public void subscribe(Subscriber s) {
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
   public EventPublisher<K> getEventPublisher() {
      return null;
   }

   @Override
   public String toString() {
      return queue.stream().collect(Collectors.joining("\n"));
   }

   public IPublisher getPublisher(){
      return null;
   }
   @MetaInfServices
   public final static class FactoryImpl<K, V> implements Factory<K, V> {

      @Override
      public ReactiveMap<K, V> apply(MapConfig mapConfig) {
         return new EmbeddedMap<>(mapConfig);
      }
   }
}
