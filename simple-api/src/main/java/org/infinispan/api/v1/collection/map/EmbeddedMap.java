package org.infinispan.api.v1.collection.map;

import java.util.Map;
import java.util.concurrent.CompletionStage;

import org.infinispan.api.v1.reactive.IPublisher;

public interface EmbeddedMap<K, V> {

   CompletionStage<Void> put(K key, V value);

   CompletionStage<V> get(K key);

   IPublisher<Map.Entry<K, V>> publisher();

   // Sync cache ?
   //SyncCache getSync();
}
