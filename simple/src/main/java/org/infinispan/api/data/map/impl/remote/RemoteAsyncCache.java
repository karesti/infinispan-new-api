package org.infinispan.api.data.map.impl.remote;

import java.util.concurrent.CompletableFuture;

import org.infinispan.api.data.map.InfinispanAsyncMap;

public class RemoteAsyncCache<K, V> implements InfinispanAsyncMap<K, V> {
   @Override
   public CompletableFuture<Void> put(K key, V value) {
      System.out.println("remote put async");
      return CompletableFuture.completedFuture(null);
   }

   @Override
   public CompletableFuture<V> get(K key) {
      System.out.println("remote get async");
      return CompletableFuture.completedFuture(null);
   }
}
