package org.infinispan.api.collection.cache;

import java.util.Map;
import java.util.concurrent.CompletionStage;

import org.infinispan.api.reactive.IPublisher;

/**
 * CACHE or MAP ?
 *
 * @param <K>
 * @param <V>
 */
public interface Cache<K, V> {

   CompletionStage<Void> put(K key, V value);

   CompletionStage<V> get(K key);

   IPublisher<Map.Entry<K, V>> publisher();

   // Sync cache ?
   //SyncCache getSync();
}
