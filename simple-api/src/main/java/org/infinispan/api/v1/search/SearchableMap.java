package org.infinispan.api.v1.search;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import org.infinispan.api.v1.collection.map.MapConfig;
import org.infinispan.api.v1.collection.map.RemoteMap;
import org.reactivestreams.Publisher;

public interface SearchableMap<K, V> {

   // Some methods like a regular cache

   CompletionStage<V> getAndPut(K key, V value);

   CompletionStage<Void> put(K key, V value);

   // Query methods
   Publisher<V> list(String ickleQuery);

   Publisher<V> list(Query query);

   // Continuous query
   ContinuousQueryPublisher<K, V> addContinuousQuery(Query query);

   ContinuousQueryPublisher<K, V> addContinuousQuery(String ickleQuery);

   interface Factory<K, V> extends Function<String, SearchableMap<K, V>> {}

}
