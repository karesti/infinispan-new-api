package org.infinispan.api.v1.impl.search;

import java.util.concurrent.CompletionStage;

import org.infinispan.api.v1.search.ContinuousQueryPublisher;
import org.infinispan.api.v1.search.Query;
import org.infinispan.api.v1.search.SearchableMap;
import org.kohsuke.MetaInfServices;
import org.reactivestreams.Publisher;

public class ClientSearchableMap<K,V> implements SearchableMap<K,V> {

   @Override
   public CompletionStage<V> getAndPut(K key, V value) {
      return null;
   }

   @Override
   public CompletionStage<Void> put(K key, V value) {
      return null;
   }

   @Override
   public Publisher<V> list(String ickleQuery) {
      return null;
   }

   @Override
   public Publisher<V> list(Query query) {
      return null;
   }

   @Override
   public ContinuousQueryPublisher<K, V> addContinuousQuery(Query query) {
      return null;
   }

   @Override
   public ContinuousQueryPublisher<K, V> addContinuousQuery(String ickleQuery) {
      return null;
   }

   @MetaInfServices
   public final static class FactoryImpl<K, V> implements SearchableMap.Factory<K, V> {

      @Override
      public SearchableMap<K, V> apply(String config) {
         return new ClientSearchableMap<>();
      }
   }
}
