package org.infinispan.api.data.map;

import java.util.concurrent.CompletableFuture;

public interface InfinispanAsyncMap<K, V> {

   CompletableFuture<Void> put(K key, V value);

   CompletableFuture<V> get(K key);
}
