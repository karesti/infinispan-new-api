package org.infinispan.api.data.map.impl.embedded;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.infinispan.api.data.map.InfinispanAsyncMap;

public class EmbeddedAsyncCache<K, V> implements InfinispanAsyncMap<K, V> {

   private Map<K, V> map = new HashMap();

   public CompletableFuture<Void> put(K key, V value) {
      map.put(key, value);
      return CompletableFuture.completedFuture(null);
   }

   public CompletableFuture<V> get(K key) {
      return CompletableFuture.completedFuture(map.get(key));
   }
}
