package org.infinispan.api.collection.impl.embedded.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.infinispan.api.collection.cache.Cache;
import org.infinispan.api.reactive.IPublisher;

public class EmbeddedAsyncCache<K, V> implements Cache<K, V> {

   private Map<K, V> map = new HashMap();

   public CompletableFuture<Void> put(K key, V value) {
      map.put(key, value);
      return CompletableFuture.completedFuture(null);
   }

   public CompletableFuture<V> get(K key) {
      return CompletableFuture.completedFuture(map.get(key));
   }

   @Override
   public IPublisher<Map.Entry<K, V>> publisher() {
      return null;
   }
}
