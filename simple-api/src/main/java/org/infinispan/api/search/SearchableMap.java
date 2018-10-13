package org.infinispan.api.search;

import java.util.concurrent.CompletionStage;

import org.reactivestreams.Publisher;

public interface SearchableMap<K, V> {

   // Some methods like a regular cache

   CompletionStage<V> putAndGet(K key, V value);

   CompletionStage<Void> put(K key, V value);

   // Query methods
   Publisher<V> list(String ickleQuery);

   CompletionStage<QueryFactory> queryFactory();

   Publisher<V> list(Query query);

   // Continuous query
   ContinuousQueryPublisher<K, V> addContinuousQuery(Query query);

   ContinuousQueryPublisher<K, V> addContinuousQuery(String ickleQuery);

}
