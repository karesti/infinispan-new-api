package org.infinispan.api.collection.map;

import java.util.Map;
import java.util.concurrent.CompletionStage;

import org.infinispan.api.reactive.InfinispanPublisher;

public interface InfinispanAsyncMap<K, V> {

   CompletionStage<Void> put(K key, V value);

   CompletionStage<V> get(K key);

   InfinispanPublisher<Map.Entry<K, V>> publisher();
}
